package INSA.TD.views.entity;

import INSA.TD.controllers.MachineController;
import INSA.TD.controllers.implementation.MachineControllerImpl;
import INSA.TD.models.Machine;
import INSA.TD.views.entity.form.MachineForm;
import INSA.TD.views.entity.tableview.MachineTableView;
import javafx.scene.Node;
import javafx.scene.control.TableView;

public class MachineView extends AbstractEntityView<Machine> {

    @Override
    protected MachineController getController() {
        return MachineControllerImpl.getInstance();
    }

    @Override
    protected TableView<Machine> createTableView() {
        return new MachineTableView(getData());
    }

    @Override
    protected MachineForm createAddForm() {
        return new MachineForm(this::addValue);
    }

    @Override
    protected Node createSpecificNode() {
        return null;
    }
}
