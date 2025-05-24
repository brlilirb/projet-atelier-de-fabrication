package INSA.TD.views.entity.tableview;

import INSA.TD.controllers.implementation.ProduitControllerImpl;
import INSA.TD.models.AbstractIdentity;
import INSA.TD.models.Gamme;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.ComboBoxTableCell;

import java.util.List;

public class GammeTableView extends AbstractEntityTableView<Gamme> {

    public GammeTableView(ObservableList<Gamme> data) {
        super(data);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void initSpecificTableColumns() {
        TableColumn<Gamme, String> refProduitCol = initRefProduitColumn();

        getColumns().addAll(refProduitCol);
    }

    private TableColumn<Gamme, String> initRefProduitColumn() {
        TableColumn<Gamme, String> refProduitCol = new TableColumn<>("Référence produit");
        refProduitCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getRefProduit()));
        refProduitCol.setCellFactory(ComboBoxTableCell.forTableColumn(getAllProduits()));
        refProduitCol.setOnEditCommit(event -> event.getRowValue().setRefProduit(event.getNewValue()));
        return refProduitCol;
    }

    private ObservableList<String> getAllProduits() {
        return FXCollections.observableArrayList(getAllProduitIds());
    }

    private List<String> getAllProduitIds() {
        return ProduitControllerImpl.getInstance()
                .afficherTous()
                .stream()
                .map(AbstractIdentity::getId)
                .toList();
    }
}
