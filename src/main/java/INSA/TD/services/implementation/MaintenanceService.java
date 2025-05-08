package INSA.TD.services.implementation;

import INSA.TD.services.SaveService;
import INSA.TD.services.files.MaintenanceDataSource;
import INSA.TD.services.files.filemanager.DataSource;

import java.util.List;
import java.util.function.Predicate;

public class MaintenanceService implements SaveService {
    private List<String> events;
    private final DataSource maintenanceDataSource;

    MaintenanceService() {
        this.maintenanceDataSource = new MaintenanceDataSource();
    }

    private List<String> getEventsById(String machineId) {
        return events.stream()
                .filter(containsId(machineId))
                .toList();
    }

    public double calculerFiabilite(String machineId) {
        double fiablility = 0.0;
        //TODO a finir
        return fiablility;
    }
    //TODO stocker fiabilité comme attribut d'une machine ?

    public void addEvent(String event) {
        events.add(event);
    }

    private static Predicate<String> containsId(String id) {
        return e -> e.contains(id);
    }
    /*TODO a revoir, pb si 2 id commencent pareil
        -> transformer chaque String de la liste en autre chose (objet? list?) pour traiter chaque élément (id machine, heure, marche/arrêt) indépendamment?
        -> du coup comment traiter les events d'une machine ensemble (pour calcul fiabilité nécessité de comparer les heures de marche et d'arrêt d'une même machine)*/

    @Override
    public void save() {
        maintenanceDataSource.writeData(events);
    }

    @Override
    public void load() {
        events = maintenanceDataSource.readData();
    }
}
