package INSA.TD.services.implementation;

import INSA.TD.exceptions.ExistException;
import INSA.TD.models.AbstractIdentity;
import INSA.TD.services.SaveService;
import INSA.TD.services.Service;
import INSA.TD.services.files.EntityDataSource;
import INSA.TD.services.files.filemanager.DataSource;

import java.util.ArrayList;
import java.util.List;

public abstract class EntityService<T extends AbstractIdentity> extends IdentityService<T> implements Service<T>, SaveService {

    private static final String EXISTE_DEJA = "La référence existe déjà.";
    private List<T> entities = new ArrayList<>();
    private DataSource entityDataSource = new EntityDataSource(getFileName());

    protected abstract String getFileName();

    @Override
    public List<T> getAll() {
        return entities;
    }

    @Override
    public T get(String id) {
        return getById(entities, id);
    }

    @Override
    public T add(T entity) throws ExistException {
        return add(entity, entities);
    }

    @Override
    public T update(T entity) {
        return update(entity, entities);
    }

    @Override
    public void delete(String id) {
        entities = deleteById(entities, id);
    }

    @Override
    public String getExistMessage() {
        return EXISTE_DEJA;
    }

    @Override
    public void save() {
        entityDataSource.writeData(entities);
    }

    @Override
    public void load() {
        entities = entityDataSource.readData();
    }

    @Override
    public void deleteAll() {
        entities.clear();
    }
}
