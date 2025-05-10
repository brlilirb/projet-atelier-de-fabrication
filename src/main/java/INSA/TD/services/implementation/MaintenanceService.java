package INSA.TD.services.implementation;

import INSA.TD.services.SaveService;
import INSA.TD.services.files.MaintenanceDataSource;
import INSA.TD.services.files.filemanager.DataSource;
import INSA.TD.utils.ConstantesUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MaintenanceService implements SaveService {
    private List<String> stringEvents;
    private final DataSource dataSource;

    public MaintenanceService() {
        this.stringEvents = new ArrayList<>();
        this.dataSource = new MaintenanceDataSource();
    }

    private List<SuiviMaintenance> splitValues() {
        return stringEvents.stream()
                .map(data -> data.split(ConstantesUtils.SPACE))
                .map(SuiviMaintenance::new)
                .toList();
    }

    //TODO attention à load les données du fichier au bon moment

    public double calculerFiabilite(String machineId) {
        double fiablility = 0.0;
        List<SuiviMaintenance> machineEvents = getEventsById(machineId);
        //TODO a finir
        return fiablility;
    }
    //TODO stocker fiabilité comme attribut d'une machine ?

    private List<SuiviMaintenance> getEventsById(String machineId) {
        return splitValues().stream()
                .filter(isIdEqual(machineId))
                .toList();
    }

    private static Predicate<SuiviMaintenance> isIdEqual(String id) {
        return e -> e.getRefMachine().equals(id);
    }

    @Override
    public void save() {
        dataSource.writeData(stringEvents);
    }

    @Override
    public void load() {
        stringEvents = dataSource.readData();
    }

    public void addEvent(String event) {
        stringEvents.add(event);
    }

    public void deleteAll() {
        stringEvents.clear();
    }
}
