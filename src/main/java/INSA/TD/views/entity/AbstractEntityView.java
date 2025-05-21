package INSA.TD.views.entity;

import INSA.TD.controllers.Controller;
import INSA.TD.utils.ClassUtils;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.lang.reflect.Field;

public abstract class AbstractEntityView<E> extends VBox {
    private TableView<E> entityTableView;

    // creation de l'affichage de chaque liste d'objet
    public void createListView() {
        entityTableView = new TableView<>();
        entityTableView.setItems((ObservableList<E>) getController().afficherTous());

        // Utiliser la réflexion pour obtenir les champs de la classe
        Field[] fields = ClassUtils.getClassType(getClass()).getDeclaredFields();

        // Créer des colonnes pour chaque champ
        for (Field field : fields) {
            TableColumn<E, String> column = new TableColumn<>(field.getName());
            column.setCellValueFactory(new PropertyValueFactory<>(field.getName()));
            entityTableView.getColumns().add(column);
        } //TODO à finir
    }

    protected abstract Controller<E> getController();
}
