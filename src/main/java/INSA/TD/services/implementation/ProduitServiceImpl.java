package INSA.TD.services.implementation;

import INSA.TD.models.Produit;
import INSA.TD.services.GammeService;
import INSA.TD.services.ProduitService;

import java.util.Objects;

public class ProduitServiceImpl extends EntityService<Produit> implements ProduitService {

    private static ProduitService instance;

    private final GammeService gammeService = GammeServiceImpl.getInstance();

    private ProduitServiceImpl() {
    }

    public static ProduitService getInstance() {
        if (Objects.isNull(instance)) {
            instance = new ProduitServiceImpl();
        }
        return instance;
    }

    @Override
    public void delete(String id) {
        gammeService.clearProduit(id);
        super.delete(id);
    }

    @Override
    public String getExistMessage() {
        return "La référence du produit existe déjà.";
    }
}
