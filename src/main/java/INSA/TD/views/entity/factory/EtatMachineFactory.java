package INSA.TD.views.entity.factory;

import INSA.TD.models.etat.machine.*;

import java.util.List;

public class EtatMachineFactory {

    public static List<EtatMachine> getEtatsMachine() {
        return List.of(
                new Disponible(),
                new Maintenance(),
                new Occupe(),
                new Panne()
        );
    }
}
