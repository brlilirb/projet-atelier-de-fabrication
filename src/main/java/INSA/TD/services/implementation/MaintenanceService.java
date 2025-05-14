package INSA.TD.services.implementation;

import INSA.TD.models.SuiviMaintenance;
import INSA.TD.services.SaveService;
import INSA.TD.services.files.MaintenanceDataSource;
import INSA.TD.services.files.filemanager.DataSource;
import INSA.TD.utils.ConstantesUtils;
import INSA.TD.utils.StringUtils;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaintenanceService implements SaveService {
    private static final String START_TIME = "06:00";
    private static final String END_TIME = "20:00";
    private List<SuiviMaintenance> events = new ArrayList<>();
    private final DataSource dataSource;
    private LocalTime startTime;
    private LocalTime endTime;

    public MaintenanceService() {
        this.dataSource = new MaintenanceDataSource();
        this.startTime = LocalTime.parse(START_TIME, ConstantesUtils.TIME_FORMATTER);
        this.endTime = LocalTime.parse(END_TIME, ConstantesUtils.TIME_FORMATTER);
    }

    public double calculerFiabilite(String machineId) {
        List<SuiviMaintenance> machineEvents = getSortedEventsById(machineId); //assure que les events sont dans l'ordre chronologique

        Duration totalDowntime = Duration.ZERO;
        Duration totalUptime = Duration.ZERO;

        LocalDateTime lastStop = null;
        LocalDateTime lastStart = null;

        for (SuiviMaintenance event : machineEvents) {
            if (event.getEtat().equals("A")) { // Attention a bien donner l'heure de demarrage en debut de journee
                lastStop = event.getDateTime(); //dès qu'un arrêt est trouvé la date et l'heure sont stockés
            } else if (event.getEtat().equals("D") && lastStop != null) { //dès qu'un démarrage est trouvé et qu'un arrêt est stocké la durée d'arrêt est stockée
                totalDowntime = totalDowntime.plus(clampToWorkHours(lastStop, event.getDateTime(), startTime, endTime)); //calcul la durée entre un arrêt et un démarrage en prenant en compte les horaires d'une journée
                if (lastStart != null) { //Si un démarrage et un arrêt sont enregistré la durée de fonctionnement est calculée
                    totalUptime = totalUptime.plus(clampToWorkHours(lastStart, lastStop, startTime, endTime));
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

        return fiablility;
    }

    /*TODO stocker fiabilité comme attribut d'une machine ?
       pour pouvoir classer les machines en fonction de leur fiabilité
        ou utiliser map
     */

    // calcule la durée pendant les heures de travail
    private static Duration clampToWorkHours(LocalDateTime start, LocalDateTime end, LocalTime workStart, LocalTime workEnd) {
        Duration result = Duration.ZERO;

        while (!start.toLocalDate().isAfter(end.toLocalDate())) { //vérifie que la date de début est toujours avant la date de fin
            LocalDate currentDay = start.toLocalDate();
            LocalDateTime dayStart = LocalDateTime.of(currentDay, workStart); //définit le début et la fin d'une journée de travail
            LocalDateTime dayEnd = LocalDateTime.of(currentDay, workEnd);

            LocalDateTime effectiveStart = start.isAfter(dayStart) ? start : dayStart; //si le début ou la fin se situe en dehors des horaires de travail, définit le début ou la fin de la journée comme début ou fin
            LocalDateTime effectiveEnd = end.isBefore(dayEnd) ? end : dayEnd;

            if (!effectiveEnd.isBefore(effectiveStart)) { //calcule la durée entre le début et la fin effectifs
                result = result.plus(Duration.between(effectiveStart, effectiveEnd));
            }

            start = LocalDateTime.of(currentDay.plusDays(1), LocalTime.MIDNIGHT); //passe au jour suivant
        }

        return result;
    }

    @Override
    public void save() {
        dataSource.writeData(events);
    }

    @Override
    public void load() {
        events = splitValues(StringUtils.convertToStringList(dataSource.readData()));
    }

    public void addEvent(SuiviMaintenance event) {
        events.add(event);
    }

    public void addStringEvent(String event) {
        events.addAll(splitValues(List.of(event)));
    }

    public void deleteAll() {
        events.clear();
    }

    private List<SuiviMaintenance> splitValues(List<String> values) {
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

    private List<SuiviMaintenance> getSortedEventsById(String machineId) {
        return getEventsById(machineId).stream()
                .sorted(Comparator.comparing(SuiviMaintenance::getDateTime))
                .toList();
    }

    private static Predicate<SuiviMaintenance> isIdEqual(String id) {
        return e -> e.getRefMachine().equals(id);
    }
}
