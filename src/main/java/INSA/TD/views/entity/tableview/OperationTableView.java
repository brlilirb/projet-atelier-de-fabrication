package INSA.TD.views.entity.tableview;

import INSA.TD.controllers.implementation.EquipementControllerImpl;
import INSA.TD.models.AbstractIdentity;
import INSA.TD.models.Operation;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.NumberStringConverter;

import java.util.List;

public class OperationTableView extends AbstractEntityTableView<Operation> {

    public OperationTableView(ObservableList<Operation> data) {
        super(data);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void initSpecificTableColumns() {
        TableColumn<Operation, String> descriptionCol = initDescriptionColumn();
        TableColumn<Operation, Number> dureeCol = initDureeColumn();
        TableColumn<Operation, String> refEquipementCol = initRefProduitColumn();

        getColumns().addAll(descriptionCol, dureeCol, refEquipementCol);
    }

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

    private TableColumn<Operation, String> initRefProduitColumn() {
        TableColumn<Operation, String> refEquipementCol = new TableColumn<>("Référence équipement");
        refEquipementCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getRefEquipement()));
        refEquipementCol.setCellFactory(ComboBoxTableCell.forTableColumn(getAllEquipements()));
        refEquipementCol.setOnEditCommit(event -> event.getRowValue().setRefEquipement(event.getNewValue()));
        return refEquipementCol;
    }

    private ObservableList<String> getAllEquipements() {
        return FXCollections.observableArrayList(getAllEquipementIds());
    }

    private List<String> getAllEquipementIds() {
        return EquipementControllerImpl.getInstance()
                .afficherTous()
                .stream()
                .map(AbstractIdentity::getId)
                .toList();
    }
}
