package INSA.TD.views.entity;

import INSA.TD.controllers.Controller;
import INSA.TD.controllers.MachineController;
import INSA.TD.controllers.implementation.MachineControllerImpl;
import INSA.TD.models.Machine;

public class MachineView extends AbstractEntityView<Machine> {
    private final MachineController machineController = MachineControllerImpl.getInstance();

    @Override
    protected Controller<Machine> getController() {
        return machineController;
    }
}
