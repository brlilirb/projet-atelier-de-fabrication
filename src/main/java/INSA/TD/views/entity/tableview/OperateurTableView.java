package INSA.TD.views.entity.tableview;

import INSA.TD.models.Operateur;
import INSA.TD.utils.StringConverterUtils;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.ChoiceBoxTableCell;
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
        TableColumn<Operateur, Boolean> etatCol = initEtatColumn();

        this.getColumns().addAll(nomCol, prenomCol, etatCol);
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

    protected TableColumn<Operateur, Boolean> initEtatColumn() {
        TableColumn<Operateur, Boolean> etatCol = new TableColumn<>("Etat");
        etatCol.setCellValueFactory(data -> new SimpleBooleanProperty(data.getValue().isLibre()));
        etatCol.setCellFactory(ChoiceBoxTableCell.forTableColumn(StringConverterUtils.toOperateurEtatStringConverter(), true, false));
        etatCol.setOnEditCommit(event -> event.getRowValue().setLibre(event.getNewValue()));
        return etatCol;
    }
}
