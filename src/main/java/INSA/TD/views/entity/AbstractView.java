package INSA.TD.views.entity;

import INSA.TD.config.ViewConfig;
import INSA.TD.controllers.Controller;
import INSA.TD.models.AbstractIdentity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;

import java.util.List;

public abstract class AbstractView<T extends AbstractIdentity> extends BorderPane implements Controller<T> { // TODO remake an interface

    private ObservableList<T> data;

    protected AbstractView() {
        setPadding(new Insets(ViewConfig.DEFAULT_SPACING));

        setData(afficherTous());
    }

    @Override
    public List<T> afficherTous() {
        return getController().afficherTous();
    }

    @Override
    public T afficher(String id) {
        return getController().afficher(id);
    }

    @Override
    public T ajouter(T entity) {
        // TODO warning when entity already exist
        return getController().ajouter(entity);
    }

    @Override
    public T modifier(T entity) {
        return getController().modifier(entity);
    }

    @Override
    public void supprimer(String id) {
        getController().supprimer(id);
    }

    @Override
    public List<T> rechercher(String id) {
        return getController().rechercher(id);
    }

    public ObservableList<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = FXCollections.observableArrayList(data);
    }

    protected abstract Controller<T> getController();

}
