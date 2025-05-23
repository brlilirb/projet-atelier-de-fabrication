package INSA.TD.views.entity.tableview;

import INSA.TD.models.Poste;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.TextFieldTableCell;

public class PosteTableView extends AbstractEntityTableView<Poste> {

    public PosteTableView(ObservableList<Poste> data) {
        super(data);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void initSpecificTableColumns() {
        TableColumn<Poste, String> descriptionCol = initDescriptionColumn();

        getColumns().addAll(descriptionCol);
    }//TODO rajouter liste machines

    protected TableColumn<Poste, String> initDescriptionColumn() {
        TableColumn<Poste, String> descriptionCol = new TableColumn<>("Description");
        descriptionCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDesignation()));
        descriptionCol.setCellFactory(TextFieldTableCell.forTableColumn());
        descriptionCol.setOnEditCommit(event -> event.getRowValue().setDesignation(event.getNewValue()));
        return descriptionCol;
    }
}
