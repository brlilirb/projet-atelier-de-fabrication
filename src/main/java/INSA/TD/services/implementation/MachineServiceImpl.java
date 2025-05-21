package INSA.TD.services.implementation;

import INSA.TD.models.Machine;
import INSA.TD.models.SuiviMaintenance;
import INSA.TD.services.MachineService;
import INSA.TD.services.MachineSuiviService;

import java.util.Objects;
import java.util.function.Function;

public class MachineServiceImpl extends AbstractSuiviService<Machine> implements MachineService, MachineSuiviService {

    private static MachineServiceImpl instance;

    private MachineServiceImpl() {
    }

    public static MachineService getInstance() {
        return getSingleton();
    }

    protected static MachineSuiviService getSuiviInstance() {
        return getSingleton();
    }

    private static MachineServiceImpl getSingleton() {
        if (Objects.isNull(instance)) {
            instance = new MachineServiceImpl();
        }
        return instance;
    }

    @Override
    public String getExistMessage() {
        return "La référence de la machine existe déjà.";
    }

    @Override
    Function<SuiviMaintenance, String> getReference() {
        return SuiviMaintenance::getRefMachine;
    }

    @Override
    Function<String, Machine> createNewEntity() {
        return Machine::new;
    }
}
