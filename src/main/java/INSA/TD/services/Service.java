package INSA.TD.services;

import INSA.TD.exceptions.ExistException;

import java.util.List;

public interface Service<E> {

    List<E> getAll();

    E get(String id);

    E add(E entity) throws ExistException;

    void delete(String id);

}
