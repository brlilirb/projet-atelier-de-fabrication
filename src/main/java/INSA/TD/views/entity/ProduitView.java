package INSA.TD.views.entity;

import INSA.TD.controllers.ProduitController;
import INSA.TD.controllers.implementation.ProduitControllerImpl;
import INSA.TD.models.Produit;

public class ProduitView extends AbstractEntityView<Produit> {
    @Override
    protected ProduitController getController() {
        return ProduitControllerImpl.getInstance();
    }

    @Override
    protected void initSpecificTableColumns() {

    }//TODO a faire (cf exemple machine)
}
