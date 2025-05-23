package INSA.TD.views.entity;

import INSA.TD.controllers.OperationController;
import INSA.TD.controllers.implementation.OperationControllerImpl;
import INSA.TD.models.Operation;
import INSA.TD.views.entity.tableview.OperationTableView;
import javafx.scene.Node;
import javafx.scene.control.TableView;

public class OperationView extends AbstractEntityView<Operation> {

    @Override
    protected OperationController getController() {
        return OperationControllerImpl.getInstance();
    }

    @Override
    protected TableView<Operation> createTableView() {
        return new OperationTableView(getData());
    }

    @Override
    protected Node createSpecificNode() {
        return null;
    }
}
