package INSA.TD.views.entity.tableview;

import INSA.TD.models.SuiviMaintenance;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;

public class SuiviMaintenanceTableView extends AbstractTableView<SuiviMaintenance> {

    public SuiviMaintenanceTableView(ObservableList<SuiviMaintenance> data) {
        super(data);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void initTableColumn() {
        TableColumn<SuiviMaintenance, String> dateCol = initDateCol();
        TableColumn<SuiviMaintenance, String> timeCol = initTimeCol();
        TableColumn<SuiviMaintenance, String> refMachineCol = initReferenceMachineCol();
        TableColumn<SuiviMaintenance, String> etatCol = initEtatCol();
        TableColumn<SuiviMaintenance, String> operateurCol = initOperateurCol();
        TableColumn<SuiviMaintenance, String> causeCol = initCauseCol();

        getColumns().addAll(dateCol, timeCol, refMachineCol, etatCol, operateurCol, causeCol);
    }

    private TableColumn<SuiviMaintenance, String> initDateCol() {
        TableColumn<SuiviMaintenance, String> dateCol = new TableColumn<>("Date");
        dateCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDate()));
        return dateCol;
    }

    private TableColumn<SuiviMaintenance, String> initTimeCol() {
        TableColumn<SuiviMaintenance, String> dateCol = new TableColumn<>("Heures");
        dateCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTime()));
        return dateCol;
    }

    private TableColumn<SuiviMaintenance, String> initReferenceMachineCol() {
        TableColumn<SuiviMaintenance, String> refMachineCol = new TableColumn<>("Référence machine");
        refMachineCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getRefMachine()));
        return refMachineCol;
    }

    private TableColumn<SuiviMaintenance, String> initEtatCol() {
        TableColumn<SuiviMaintenance, String> refMachineCol = new TableColumn<>("Etat");
        refMachineCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getEtat()));
        return refMachineCol;
    }

    private TableColumn<SuiviMaintenance, String> initOperateurCol() {
        TableColumn<SuiviMaintenance, String> operateurCol = new TableColumn<>("Opérateur");
        operateurCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getOperateur()));
        return operateurCol;
    }

    private TableColumn<SuiviMaintenance, String> initCauseCol() {
        TableColumn<SuiviMaintenance, String> causeCol = new TableColumn<>("Cause");
        causeCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCause()));
        return causeCol;
    }
}
