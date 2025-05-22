package INSA.TD.views.entity;

import INSA.TD.models.AbstractIdentity;
import INSA.TD.views.button.DeleteButton;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ListChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import static INSA.TD.config.ViewConfig.DEFAULT_SPACING;

public abstract class AbstractEntityView<T extends AbstractIdentity> extends AbstractView<T> {

    private final TableView<T> tableView = new TableView<>();
    private Button deleteButton = new DeleteButton();

    protected AbstractEntityView() {
        super();
        setSpacing(DEFAULT_SPACING);
        setPadding(new Insets(DEFAULT_SPACING));

        getChildren().addAll(tableView, deleteButton);

        tableView.setItems(getData());

        initTableColumn();
        initListener();
        
        deleteButton.setVisible(false); //TODO ne pas afficher pour ouvrier
        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                deleteButton.setVisible(true);
            } else {
                deleteButton.setVisible(false);
            }
        });
        deleteButton.setOnAction(event -> {
            T selected = tableView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                getData().remove(selected); // Supprimer l'objet sélectionné de la liste
                deleteButton.setVisible(false); // Masquer le bouton après suppression
            }
        });
    }

    @SuppressWarnings("unchecked")
    protected void initTableColumn() {
        TableColumn<T, String> referenceColumn = new TableColumn<>("Référence");
        referenceColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getId()));
        getTableView().getColumns().addAll(referenceColumn);

        initSpecificTableColumns();
    }


    public void initListener() {
        getData().addListener((ListChangeListener<T>) change -> {
            while (change.next()) {
                if (change.wasAdded()) {
                    ajouter(change.getAddedSubList().getFirst());
                } else if (change.wasRemoved()) {
                    supprimer(change.getRemoved().getFirst().getId());
                }
            }
        });

    }

    public TableView<T> getTableView() {
        return tableView;
    }

    protected abstract void initSpecificTableColumns();
}
