package INSA.TD.services.implementation;

import INSA.TD.exceptions.ExistException;
import INSA.TD.models.Poste;
import INSA.TD.services.PosteService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PosteServiceImpl extends IdentityService<Poste> implements PosteService {

    private static PosteServiceImpl instance;
    private static final String EXISTE_DEJA = "La référence de poste existe déjà.";
    private List<Poste> listePostes = new ArrayList<>();

    private PosteServiceImpl() {
    }

    public static PosteService getInstance() {
        if (Objects.isNull(instance)) {
            instance = new PosteServiceImpl();
        }
        return instance;
    }

    @Override
    public List<Poste> getAll() {
        return listePostes;
    }

    @Override
    public Poste get(String id) {
        return getById(listePostes, id);
    }

    @Override
    public Poste add(Poste entity) throws ExistException {
        return add(entity, listePostes, EXISTE_DEJA);
    }

    @Override
    public Poste update(Poste entity) {
        return update(entity, listePostes);
    }

    @Override
    public void delete(String id) {
        listePostes = deleteById(listePostes, id);
    }
}
