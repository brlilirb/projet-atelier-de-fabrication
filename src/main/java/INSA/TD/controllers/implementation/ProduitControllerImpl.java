package INSA.TD.controllers.implementation;

import INSA.TD.controllers.ProduitController;
import INSA.TD.models.Produit;
import INSA.TD.services.ProduitService;
import INSA.TD.services.implementation.ProduitServiceImpl;

public class ProduitControllerImpl extends AbstractEntityController<Produit> implements ProduitController {

    private static ProduitControllerImpl instance;

    private ProduitService produitService = ProduitServiceImpl.getInstance();

    private ProduitControllerImpl() {
    }

    public static ProduitController getInstance() {
        if (instance == null) {
            instance = new ProduitControllerImpl();
        }
        return instance;
    }

    @Override
    protected ProduitService getService() {
        return produitService;
    }
}
