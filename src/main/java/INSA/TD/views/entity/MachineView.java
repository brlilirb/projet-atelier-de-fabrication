package INSA.TD.views.entity;

import INSA.TD.controllers.MachineController;
import INSA.TD.controllers.implementation.MachineControllerImpl;
import INSA.TD.models.Machine;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.NumberStringConverter;

public class MachineView extends AbstractEntityView<Machine> {

    @Override
    @SuppressWarnings("unchecked")
    protected void initSpecificTableColumns() {
        // TODO make other columns
        initDescriptionColumn();

        getTableView().getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        getTableView().setEditable(true);
        TableColumn<Machine, Number> coutCol = new TableColumn<>("Cout");
        coutCol.setCellValueFactory(data -> new SimpleFloatProperty(data.getValue().getCout()));
        coutCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        coutCol.setOnEditCommit(event -> {
            event.getRowValue().setCout(event.getNewValue().floatValue());
        });

        getTableView().getColumns().addAll(coutCol);
    }

    @SuppressWarnings("unchecked")
    protected void initDescriptionColumn() {
        TableColumn<Machine, String> descriptionCol = new TableColumn<>("Description");
        descriptionCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDesignation()));
        descriptionCol.setCellFactory(TextFieldTableCell.forTableColumn());
        descriptionCol.setOnEditCommit(event -> {
            event.getRowValue().setDesignation(event.getNewValue());
        });
        getTableView().getColumns().addAll(descriptionCol);
    }

    @Override
    protected MachineController getController() {
        return MachineControllerImpl.getInstance();
    }
}
