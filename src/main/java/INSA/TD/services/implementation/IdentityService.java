package INSA.TD.services.implementation;

import INSA.TD.exceptions.ExistException;
import INSA.TD.models.AbstractIdentity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class IdentityService<E extends AbstractIdentity> {

    public E getById(List<E> list, String id) {
        return list.stream()
                .filter(isIdEqual(id))
                .findFirst()
                .orElse(null);
    }

    public List<E> deleteById(List<E> list, String id) {
        return new ArrayList<>(
                list.stream()
                        .filter(Predicate.not(isIdEqual(id)))
                        .toList()
        );
    }

    private static <E extends AbstractIdentity> Predicate<E> isIdEqual(String id) {
        return e -> e.getId().equals(id);
    }

    public boolean existById(List<E> list, E entity) {
        return existById(
                list,
                entity.getId()
        );
    }

    public boolean existById(List<E> list, String id) {
        return list.stream()
                .anyMatch(isIdEqual(id));
    }

    public E add(E entity, List<E> list, String message) throws ExistException {
        if (existById(list, entity)) {
            throw new ExistException(message);
        }
        list.add(entity);
        return entity;

    }

    public E add(E entity, List<E> list) throws ExistException {
        return add(entity, list, getExistMessage());
    }

    public int getIndexById(List<E> list, E entity) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(entity.getId())) {
                return i;
            }
        }
        return -1;
    }

    public E update(E entity, List<E> list) {
        int index = getIndexById(list, entity);
        if (index != -1) {
            list.set(index, entity);
            return entity;
        }
        list.add(entity);
        return entity;
    }

    public List<E> search(List<E> list, String value) {
        return search(list, getDefaultPredicate(value));
    }

    public List<E> search(List<E> list, Predicate<E> filter) {
        return list.stream()
                .filter(filter)
                .toList();
    }

    public abstract String getExistMessage();

    protected Predicate<E> getDefaultPredicate(String value) {
        return objet -> objet.getId().contains(value);
    }
}
