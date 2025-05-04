package INSA.TD.services.implementation;

import INSA.TD.models.Poste;
import INSA.TD.services.PosteService;

import java.util.Objects;

public class PosteServiceImpl extends EntityService<Poste> implements PosteService {

    private static PosteServiceImpl instance;

    private PosteServiceImpl() {
    }

    public static PosteService getInstance() {
        if (Objects.isNull(instance)) {
            instance = new PosteServiceImpl();
        }
        return instance;
    }

    @Override
    protected String getFileName() {
        return Poste.class.getSimpleName().toLowerCase();
    }

    @Override
    public String getExistMessage() {
        return "La référence du poste existe déjà.";
    }
}
