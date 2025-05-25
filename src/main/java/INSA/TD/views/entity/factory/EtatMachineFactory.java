package INSA.TD.views.entity.factory;

import INSA.TD.models.etat.machine.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class EtatMachineFactory {

    private EtatMachineFactory() {
    }

    public static ObservableList<String> getEtats() {
        return FXCollections.observableArrayList("A", "D");
    }

    public static ObservableList<String> getCauses() {
        ObservableList<String> causes = FXCollections.observableArrayList(getEtatExternes(getUnavailableEtatsMachine()));
        causes.addFirst("X");
        return causes;
    }

    private static List<String> getEtatExternes(List<EtatMachine> etatsMachine) {
        return etatsMachine.stream()
                .map(EtatMachine::getEtatExterne)
                .map(Enum::name)
                .toList();
    }

    public static ObservableList<EtatMachine> getEtatMachines() {
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

    public static List<EtatMachine> getUnavailableEtatsMachine() {
        return List.of(
                new Maintenance(),
                new Panne()
        );
    }
}
