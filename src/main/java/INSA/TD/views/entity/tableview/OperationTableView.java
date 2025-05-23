package INSA.TD.views.entity.tableview;

import INSA.TD.models.Operation;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.NumberStringConverter;

public class OperationTableView extends AbstractEntityTableView<Operation> {

    public OperationTableView(ObservableList<Operation> data) {
        super(data);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void initSpecificTableColumns() {
        TableColumn<Operation, String> descriptionCol = initDescriptionColumn();
        TableColumn<Operation, Number> dureeCol = initDureeColumn();

        getColumns().addAll(descriptionCol, dureeCol);
    }//TODO ajouter équipement; ref ou objet complet ?

    protected TableColumn<Operation, String> initDescriptionColumn() {
        TableColumn<Operation, String> descriptionCol = new TableColumn<>("Description");
        descriptionCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDesignation()));
        descriptionCol.setCellFactory(TextFieldTableCell.forTableColumn());
        descriptionCol.setOnEditCommit(event -> event.getRowValue().setDesignation(event.getNewValue()));
        return descriptionCol;
    }

    protected TableColumn<Operation, Number> initDureeColumn() {
        TableColumn<Operation, Number> dureeCol = new TableColumn<>("Durée (en heures)");
        dureeCol.setCellValueFactory(data -> new SimpleFloatProperty(data.getValue().getDureeOperation()));
        dureeCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        dureeCol.setOnEditCommit(event -> event.getRowValue().setDureeOperation(event.getNewValue().floatValue()));
        dureeCol.setMinWidth(200);
        return dureeCol;
    }
}
