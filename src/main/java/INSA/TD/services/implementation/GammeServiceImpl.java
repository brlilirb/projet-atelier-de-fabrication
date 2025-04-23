package INSA.TD.services.implementation;

import INSA.TD.exceptions.ExistException;
import INSA.TD.models.Gamme;
import INSA.TD.services.GammeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GammeServiceImpl extends IdentityService<Gamme> implements GammeService {

    private static GammeServiceImpl instance;
    private static final String EXISTE_DEJA = "La référence de gamme existe déjà.";
    private List<Gamme> listeGammes = new ArrayList<>();

    private GammeServiceImpl() {
    }

    public static GammeService getInstance() {
        if (Objects.isNull(instance)) {
            instance = new GammeServiceImpl();
        }
        return instance;
    }

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
    public Gamme update(Gamme entity) {
        return update(entity, listeGammes);
    }

    @Override
    public void delete(String id) {
        listeGammes = deleteById(listeGammes, id);
    }
}
