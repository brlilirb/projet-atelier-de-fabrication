package INSA.TD.views.entity;

import INSA.TD.controllers.ProduitController;
import INSA.TD.controllers.implementation.ProduitControllerImpl;
import INSA.TD.models.Produit;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.TextFieldTableCell;

public class ProduitView extends AbstractEntityView<Produit> {
    @Override
    protected ProduitController getController() {
        return ProduitControllerImpl.getInstance();
    }

    @Override
    protected void initSpecificTableColumns() {
        TableColumn<Produit, String> descriptionCol = initDescriptionColumn();

        getTableView().getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        getTableView().setEditable(true);

        getTableView().getColumns().addAll(descriptionCol);
    }

    protected TableColumn<Produit, String> initDescriptionColumn() {
        TableColumn<Produit, String> descriptionCol = new TableColumn<>("Description");
        descriptionCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDesignation()));
        descriptionCol.setCellFactory(TextFieldTableCell.forTableColumn());
        descriptionCol.setOnEditCommit(event -> {
            event.getRowValue().setDesignation(event.getNewValue());
        });
        return descriptionCol;
    }
}
