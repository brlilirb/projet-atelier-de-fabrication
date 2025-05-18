package INSA.TD.services.implementation;

import INSA.TD.models.Fiabilite;
import INSA.TD.models.Machine;
import INSA.TD.models.SuiviMaintenance;
import INSA.TD.services.MachineSuiviService;
import INSA.TD.services.MaintenanceService;
import INSA.TD.services.OperateurSuiviService;
import INSA.TD.services.files.MaintenanceDataSource;
import INSA.TD.services.files.filemanager.DataSource;
import INSA.TD.utils.ConstantesUtils;
import INSA.TD.utils.TimeUtils;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MaintenanceServiceImpl implements MaintenanceService {

    private static MaintenanceServiceImpl instance;

    private List<SuiviMaintenance> events = new ArrayList<>();
    private final DataSource dataSource;
    private final MachineSuiviService machineService;
    private final OperateurSuiviService operateurService;

    private MaintenanceServiceImpl() {
        this.dataSource = new MaintenanceDataSource();
        this.machineService = MachineServiceImpl.getSuiviInstance();
        this.operateurService = OperateurServiceImpl.getSuiviInstance();
    }

    public static MaintenanceServiceImpl getInstance() {
        if (Objects.isNull(instance)) {
            instance = new MaintenanceServiceImpl();
        }
        return instance;
    }

    public List<SuiviMaintenance> getAll() {
        return events;
    }

    public Fiabilite computeFiabilite(String machineId) {
        List<SuiviMaintenance> machineEvents = getSortedEventsById(machineId); //assure que les events sont dans l'ordre chronologique

        Duration totalDowntime = Duration.ZERO;
        Duration totalUptime = Duration.ZERO;

        LocalDateTime lastStop = null;
        LocalDateTime lastStart = null;

        for (SuiviMaintenance event : machineEvents) {
            if (event.getEtat().equals("A")) { // Attention a bien donner l'heure de demarrage en debut de journee
                lastStop = event.getDateTime(); //dès qu'un arrêt est trouvé la date et l'heure sont stockés
            } else if (event.getEtat().equals("D") && lastStop != null) { //dès qu'un démarrage est trouvé et qu'un arrêt est stocké la durée d'arrêt est stockée
                totalDowntime = totalDowntime.plus(clampToWorkHours(lastStop, event.getDateTime())); //calcul la durée entre un arrêt et un démarrage en prenant en compte les horaires d'une journée
                if (lastStart != null) { //Si un démarrage et un arrêt sont enregistré la durée de fonctionnement est calculée
                    totalUptime = totalUptime.plus(clampToWorkHours(lastStart, lastStop));
                }
                lastStart = event.getDateTime(); //puisque "D" a été trouvé, l'heure de démarrage est enregistrée
                lastStop = null; //l'heure d'arrêt est réinitialisée
            }
        }

        long totalMinutes = totalUptime.plus(totalDowntime).toMinutes();
        double fiablility = totalMinutes > 0 ? (double) totalUptime.toMinutes() / totalMinutes : 0;

        System.out.println("Machine: " + machineId);
        System.out.println("  temps total de fonctionnement: " + totalUptime.toMinutes() + " mins");
        System.out.println("  temps total d'arrêt: " + totalDowntime.toMinutes() + " mins");
        System.out.printf("  fiabilité: %.2f%%\n", fiablility * 100);

        return new Fiabilite(machineId, fiablility, totalDowntime, totalUptime);
    }

    public List<Fiabilite> computeAllFiabilites() { //en partant du principe que les machines présentent dans le fichier de suivi ont été créée
        return getMachinesId()
                .stream()
                .map(this::computeFiabilite)
                .toList();
    }

    public Map<Machine, Fiabilite> sortMachineByFiability(boolean order) {
        return computeAllFiabilites()
                .stream()
                .sorted(fiabiliteSortOrder(order))
                .collect(Collectors.toMap(
                        fiabilite -> machineService.get(fiabilite.reference()),
                        fiabilite -> fiabilite,
                        (_, newValue) -> newValue,
                        LinkedHashMap::new
                ));
    }

    @Override
    public void save() {
        dataSource.writeData(events);
    }

    @Override
    public void load() {
        events = new ArrayList<>(createSuiviMaintenanceList(dataSource.readData()));
        initNoExistedData();
    }

    public SuiviMaintenance addEvent(SuiviMaintenance event) {
        events.add(event);
        return event;
    }

    public List<SuiviMaintenance> getSortedEventsById(String machineId) {
        return getEventsById(machineId)
                .stream()
                .sorted(Comparator.comparing(SuiviMaintenance::getDateTime))
                .toList();
    }

    public SuiviMaintenance update(SuiviMaintenance event) {
        int index = events.indexOf(event);
        if (index != -1) {
            events.set(index, event);
            return event;
        }
        events.add(event);
        return event;
    }

    @Override
    public void deleteEvent(SuiviMaintenance event) {
        events.remove(event);
    }

    public void deleteAll() {
        events.clear();
    }

    //Calcule la durée pendant les heures de travail
    private static Duration clampToWorkHours(LocalDateTime start, LocalDateTime end) {
        Duration result = Duration.ZERO;

        while (!start.toLocalDate().isAfter(end.toLocalDate())) { //vérifie que la date de début est toujours avant la date de fin
            LocalDate currentDay = start.toLocalDate();
            LocalDateTime dayStart = LocalDateTime.of(currentDay, TimeUtils.getStartTime()); //définit le début et la fin d'une journée de travail
            LocalDateTime dayEnd = LocalDateTime.of(currentDay, TimeUtils.getEndTime());

            LocalDateTime effectiveStart = start.isAfter(dayStart) ? start : dayStart; //si le début ou la fin se situe en dehors des horaires de travail, définit le début ou la fin de la journée comme début ou fin
            LocalDateTime effectiveEnd = end.isBefore(dayEnd) ? end : dayEnd;

            if (!effectiveEnd.isBefore(effectiveStart)) { //calcule la durée entre le début et la fin effectifs
                result = result.plus(Duration.between(effectiveStart, effectiveEnd));
            }

            start = LocalDateTime.of(currentDay.plusDays(1), LocalTime.MIDNIGHT); //passe au jour suivant
        }

        return result;
    }

    private void initNoExistedData() {
        machineService.addNoExistData(events);
        operateurService.addNoExistData(events);
    }

    private List<String> getMachinesId() {
        return machineService.getAll()
                .stream()
                .map(Machine::getId)
                .toList();
    }

    private List<SuiviMaintenance> createSuiviMaintenanceList(List<String> values) {
        return values.stream()
                .map(data -> data.split(ConstantesUtils.SPACE))
                .map(SuiviMaintenance::new)
                .toList();
    }

    private List<SuiviMaintenance> getEventsById(String machineId) {
        return events.stream()
                .filter(isIdEqual(machineId))
                .toList();
    }

    private static Predicate<SuiviMaintenance> isIdEqual(String id) {
        return e -> e.getRefMachine().equals(id);
    }

    private static Comparator<Fiabilite> fiabiliteSortOrder(boolean order) {
        return order ? Comparator.comparing(Fiabilite::fiabilite).reversed() : Comparator.comparing(Fiabilite::fiabilite);
    }
}
