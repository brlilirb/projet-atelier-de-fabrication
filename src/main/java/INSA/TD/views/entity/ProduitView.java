package INSA.TD.views.entity;

import INSA.TD.controllers.Controller;
import INSA.TD.controllers.ProduitController;
import INSA.TD.controllers.implementation.ProduitControllerImpl;
import INSA.TD.models.Produit;

public class ProduitView extends AbstractEntityView<Produit> {
    private final ProduitController produitController = ProduitControllerImpl.getInstance();

    @Override
    protected Controller<Produit> getController() {
        return produitController;
    }
}
