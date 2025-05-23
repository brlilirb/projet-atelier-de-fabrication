package INSA.TD.views.entity.tableview;

import INSA.TD.models.Operateur;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.TextFieldTableCell;

public class OperateurTableView extends AbstractEntityTableView<Operateur> {

    public OperateurTableView(ObservableList<Operateur> data) {
        super(data);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void initSpecificTableColumns() {
        TableColumn<Operateur, String> nomCol = initNomColumn();
        TableColumn<Operateur, String> prenomCol = initPrenomColumn();

        this.getColumns().addAll(nomCol, prenomCol); //TODO ajouter libre, checkbox ?
    }

    protected TableColumn<Operateur, String> initNomColumn() {
        TableColumn<Operateur, String> nomCol = new TableColumn<>("Nom");
        nomCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNom()));
        nomCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nomCol.setOnEditCommit(event -> event.getRowValue().setNom(event.getNewValue()));
        return nomCol;
    }

    protected TableColumn<Operateur, String> initPrenomColumn() {
        TableColumn<Operateur, String> prenomCol = new TableColumn<>("Prénom");
        prenomCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPrenom()));
        prenomCol.setCellFactory(TextFieldTableCell.forTableColumn());
        prenomCol.setOnEditCommit(event -> event.getRowValue().setPrenom(event.getNewValue()));
        return prenomCol;
    }
}
