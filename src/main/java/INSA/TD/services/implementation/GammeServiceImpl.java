package INSA.TD.services.implementation;

import INSA.TD.exceptions.ExistException;
import INSA.TD.models.Gamme;
import INSA.TD.services.GammeService;

import java.util.ArrayList;
import java.util.List;

public class GammeServiceImpl extends IdentityService<Gamme> implements GammeService {
    private static final String EXISTE_DEJA = "La référence de gamme existe déjà.";

    private List<Gamme> listeGammes = new ArrayList<>();

    @Override
    public List<Gamme> getAll() {
        return listeGammes;
    }

    @Override
    public Gamme get(String id) {
        return getById(listeGammes, id);
    }

    @Override
    public Gamme add(Gamme entity) throws ExistException {
        return add(entity, listeGammes, EXISTE_DEJA);
    }

    @Override
    public void delete(String id) {
        listeGammes = deleteById(listeGammes, id);
    }
}
