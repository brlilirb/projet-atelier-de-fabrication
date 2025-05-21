package INSA.TD.controllers;

import INSA.TD.exceptions.ExistException;

import java.util.List;

public interface Controller<E> {

    List<E> afficherTous();

    E afficher(String id);

    E ajouter(E entity) throws ExistException;

    E modifier(E entity);

    void supprimer(String id);

    List<E> rechercher(String id);
}
