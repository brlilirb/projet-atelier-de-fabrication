package INSA.TD.views.entity;

import INSA.TD.controllers.OperationController;
import INSA.TD.controllers.implementation.OperationControllerImpl;
import INSA.TD.models.Operation;
import INSA.TD.views.entity.form.AbstractForm;
import INSA.TD.views.entity.form.OperationForm;
import INSA.TD.views.entity.tableview.OperationTableView;
import INSA.TD.views.label.TitleBox;
import javafx.scene.Node;
import javafx.scene.control.TableView;

public class OperationView extends AbstractEntityView<Operation> {

    public OperationView() {
        setTop(new TitleBox("Opérations"));
    }

    @Override
    protected OperationController getController() {
        return OperationControllerImpl.getInstance();
    }

    @Override
    protected TableView<Operation> createTableView() {
        return new OperationTableView(getData());
    }

    @Override
    protected AbstractForm<Operation> createAddForm() {
        return new OperationForm(this::addValue);
    }

    @Override
    protected Node createSpecificNode() {
        return null;
    }
}
