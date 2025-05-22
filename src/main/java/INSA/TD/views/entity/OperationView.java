package INSA.TD.views.entity;

import INSA.TD.controllers.OperationController;
import INSA.TD.controllers.implementation.OperationControllerImpl;
import INSA.TD.models.Operation;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.NumberStringConverter;

public class OperationView extends AbstractEntityView<Operation> {
    @Override
    protected OperationController getController() {
        return OperationControllerImpl.getInstance();
    }

    @Override
    protected void initSpecificTableColumns() {
        TableColumn<Operation, String> descriptionCol = initDescriptionColumn();
        TableColumn<Operation, Number> dureeCol = initDureeColumn();

        getTableView().getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        getTableView().setEditable(true);

        getTableView().getColumns().addAll(descriptionCol, dureeCol);
    }//TODO ajouter équipement; ref ou objet complet ?

    protected TableColumn<Operation, String> initDescriptionColumn() {
        TableColumn<Operation, String> descriptionCol = new TableColumn<>("Description");
        descriptionCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDesignation()));
        descriptionCol.setCellFactory(TextFieldTableCell.forTableColumn());
        descriptionCol.setOnEditCommit(event -> {
            event.getRowValue().setDesignation(event.getNewValue());
        });
        return descriptionCol;
    }

    protected TableColumn<Operation, Number> initDureeColumn() {
        TableColumn<Operation, Number> dureeCol = new TableColumn<>("Durée (en heures)");
        dureeCol.setCellValueFactory(data -> new SimpleFloatProperty(data.getValue().getDureeOperation()));
        dureeCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        dureeCol.setOnEditCommit(event -> {
            event.getRowValue().setDureeOperation(event.getNewValue().floatValue());
        });
        return dureeCol;
    }
}
