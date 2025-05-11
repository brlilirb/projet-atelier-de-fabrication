package INSA.TD.services.implementation;

import INSA.TD.services.SaveService;
import INSA.TD.services.files.MaintenanceDataSource;
import INSA.TD.services.files.filemanager.DataSource;
import INSA.TD.utils.ConstantesUtils;
import INSA.TD.utils.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaintenanceService implements SaveService {
    private static final String START_TIME = "06:00";
    private static final String END_TIME = "20:00";
    private List<SuiviMaintenance> events = new ArrayList<>();
    private final DataSource dataSource;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public MaintenanceService() {
        this.dataSource = new MaintenanceDataSource();
        this.startTime = LocalDateTime.parse(START_TIME, ConstantesUtils.TIME_FORMATTER);
        this.endTime = LocalDateTime.parse(END_TIME, ConstantesUtils.TIME_FORMATTER);
    }

    public double calculerFiabilite(String machineId) {
        double fiablility = 0.0;

        List<SuiviMaintenance> machineEvents = getEventsById(machineId).stream()
                .sorted(Comparator.comparing(SuiviMaintenance::getDateTime))
                .toList(); //assure que les events sont dans l'ordre chronologique

        double dureeJour = startTime.until(endTime, ChronoUnit.MINUTES);
        LocalDate date = machineEvents.get(0).getDateTime().toLocalDate();
        int i = 0;
        while (date.isEqual(machineEvents.get(i).getDateTime().toLocalDate()) && i < machineEvents.size()) {

            i += 1;
        }

        //TODO a finir (utiliser dateTime pour comparer les events et etat pour vérifier alternance de marche arrêt)
        // ET A REVOIR/ OPTIMISER
        return fiablility;
    }

    //TODO stocker fiabilité comme attribut d'une machine ?

    @Override
    public void save() {
        dataSource.writeData(events);
    }

    @Override
    public void load() {
        events = splitValues();
    }

    public void addEvent(SuiviMaintenance event) {
        events.add(event);
    }

    public void deleteAll() {
        events.clear();
    }

    private List<SuiviMaintenance> splitValues() {
        return StringUtils.convertToStringList(dataSource.readData()).stream()
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
}
