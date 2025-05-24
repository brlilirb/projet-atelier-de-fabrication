package INSA.TD.views.entity.factory;

import INSA.TD.models.etat.machine.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class EtatMachineFactory {

    private EtatMachineFactory() {
    }

    public static ObservableList<EtatMachine> getObservableEtatsMachine() {
        return FXCollections.observableArrayList(getEtatsMachine());
    }

    public static List<EtatMachine> getEtatsMachine() {
        return List.of(
                new Disponible(),
                new Maintenance(),
                new Occupe(),
                new Panne()
        );
    }
}
