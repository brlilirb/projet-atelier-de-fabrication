package INSA.TD.services.implementation;

import INSA.TD.exceptions.ExistException;
import INSA.TD.models.Produit;
import INSA.TD.services.ProduitService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProduitServiceImpl extends IdentityService<Produit> implements ProduitService {

    private static ProduitService instance;
    private static final String EXISTE_DEJA = "La référence du produit existe déjà.";
    private List<Produit> listeProduits = new ArrayList<>();

    private ProduitServiceImpl() {
    }

    public static ProduitService getInstance() {
        if (Objects.isNull(instance)) {
            instance = new ProduitServiceImpl();
        }
        return instance;
    }

    @Override
    public List<Produit> getAll() {
        return listeProduits;
    }

    @Override
    public Produit get(String id) {
        return getById(listeProduits, id);
    }

    @Override
    public Produit add(Produit entity) throws ExistException {
        return add(entity, listeProduits, EXISTE_DEJA);
    }

    @Override
    public Produit update(Produit entity) {
        return update(entity, listeProduits);
    }

    @Override
    public void delete(String id) {
        listeProduits = deleteById(listeProduits, id);
    }
}
