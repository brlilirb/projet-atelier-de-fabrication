package INSA.TD.views.entity.tableview;

import INSA.TD.models.Produit;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.TextFieldTableCell;

public class ProduitTableView extends AbstractTableView<Produit> {

    public ProduitTableView(ObservableList<Produit> data) {
        super(data);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void initSpecificTableColumns() {
        TableColumn<Produit, String> descriptionCol = initDescriptionColumn();

        getColumns().addAll(descriptionCol);
    }

    protected TableColumn<Produit, String> initDescriptionColumn() {
        TableColumn<Produit, String> descriptionCol = new TableColumn<>("Description");
        descriptionCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDesignation()));
        descriptionCol.setCellFactory(TextFieldTableCell.forTableColumn());
        descriptionCol.setOnEditCommit(event -> event.getRowValue().setDesignation(event.getNewValue()));
        return descriptionCol;
    }
}
