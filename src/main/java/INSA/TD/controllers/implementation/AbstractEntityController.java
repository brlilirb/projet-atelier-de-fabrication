package INSA.TD.controllers.implementation;

import INSA.TD.controllers.Controller;
import INSA.TD.exceptions.ExistException;
import INSA.TD.models.AbstractIdentity;
import INSA.TD.services.Service;

import java.util.List;

public abstract class AbstractEntityController<T extends AbstractIdentity> implements Controller<T> {

    protected abstract Service<T> getService();

    @Override
    public List<T> afficherTous() {
        return getService().getAll();
    }

    @Override
    public T afficher(String id) {
        return getService().get(id);
    }

    @Override
    public T ajouter(T entity) throws ExistException {
        return getService().add(entity);
    }

    @Override
    public T modifier(T entity) {
        return getService().update(entity);
    }

    @Override
    public void supprimer(String id) {
        getService().delete(id);
    }
}
