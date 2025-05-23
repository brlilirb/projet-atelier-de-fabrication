package INSA.TD.views.entity;

import INSA.TD.controllers.ProduitController;
import INSA.TD.controllers.implementation.ProduitControllerImpl;
import INSA.TD.models.Produit;
import INSA.TD.views.entity.tableview.ProduitTableView;
import javafx.scene.Node;
import javafx.scene.control.TableView;

public class ProduitView extends AbstractEntityView<Produit> {

    @Override
    protected ProduitController getController() {
        return ProduitControllerImpl.getInstance();
    }

    @Override
    protected TableView<Produit> createTableView() {
        return new ProduitTableView(getData());
    }

    @Override
    protected Node createSpecificNode() {
        return null;
    }
}
