package INSA.TD.views.entity;

import INSA.TD.controllers.OperateurController;
import INSA.TD.controllers.implementation.OperateurControllerImpl;
import INSA.TD.models.Operateur;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.TextFieldTableCell;

public class OperateurView extends AbstractEntityView<Operateur> {
    @Override
    protected OperateurController getController() {
        return OperateurControllerImpl.getInstance();
    }

    @Override
    protected void initSpecificTableColumns() {
        TableColumn<Operateur, String> nomCol = initNomColumn();
        TableColumn<Operateur, String> prenomCol = initPrenomColumn();

        getTableView().getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        getTableView().setEditable(true);

        getTableView().getColumns().addAll(nomCol, prenomCol); //TODO ajouter libre, checkbox ?
    }

    protected TableColumn<Operateur, String> initNomColumn() {
        TableColumn<Operateur, String> nomCol = new TableColumn<>("Nom");
        nomCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNom()));
        nomCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nomCol.setOnEditCommit(event -> {
            event.getRowValue().setNom(event.getNewValue());
        });
        return nomCol;
    }

    protected TableColumn<Operateur, String> initPrenomColumn() {
        TableColumn<Operateur, String> prenomCol = new TableColumn<>("Prénom");
        prenomCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPrenom()));
        prenomCol.setCellFactory(TextFieldTableCell.forTableColumn());
        prenomCol.setOnEditCommit(event -> {
            event.getRowValue().setPrenom(event.getNewValue());
        });
        return prenomCol;
    }
}
