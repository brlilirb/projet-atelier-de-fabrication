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
                lastStop = event.getDateTime();
            } else if (event.getEtat().equals("D") && lastStop != null) {
                // Clamp downtime to working hours
                totalDowntime = totalDowntime.plus(clampToWorkHours(lastStop, event.getDateTime(), startTime, endTime));
                if (lastStart != null) {
                    totalUptime = totalUptime.plus(clampToWorkHours(lastStart, lastStop, startTime, endTime));
                }
                lastStart = event.getDateTime();
                lastStop = null;
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
    //TODO stocker fiabilité comme attribut d'une machine ? pour pouvoir classer les machines en fonction de leur fiabilité

    // Calculate duration within working hours
    private static Duration clampToWorkHours(LocalDateTime start, LocalDateTime end, LocalTime workStart, LocalTime workEnd) {
        Duration result = Duration.ZERO;

        while (!start.toLocalDate().isAfter(end.toLocalDate())) {
            LocalDate currentDay = start.toLocalDate();
            LocalDateTime dayStart = LocalDateTime.of(currentDay, workStart);
            LocalDateTime dayEnd = LocalDateTime.of(currentDay, workEnd);

            LocalDateTime effectiveStart = start.isAfter(dayStart) ? start : dayStart;
            LocalDateTime effectiveEnd = end.isBefore(dayEnd) ? end : dayEnd;

            if (!effectiveEnd.isBefore(effectiveStart)) {
                result = result.plus(Duration.between(effectiveStart, effectiveEnd));
            }

            start = LocalDateTime.of(currentDay.plusDays(1), LocalTime.MIDNIGHT);
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
