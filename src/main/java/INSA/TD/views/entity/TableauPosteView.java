package INSA.TD.views.entity;

import INSA.TD.controllers.PosteController;
import INSA.TD.controllers.implementation.PosteControllerImpl;
import INSA.TD.models.Poste;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

import java.util.function.Consumer;


public class TableauPosteView extends AbstractEntityView<Poste> {

    private Consumer<Poste> voirClicked;

    public void setOnVoirClicked(Consumer<Poste> onVoirClicked) {
        this.voirClicked = onVoirClicked;
    }

    @Override
    protected void initSpecificTableColumns() {
        // Ajoute les colonnes spécifiques du poste ici (ex: nom, type...)

        TableColumn<Poste, Void> voirCol = new TableColumn<>("Machines");

        voirCol.setCellFactory(new Callback<>() {
            @Override
            public TableCell<Poste, Void> call(final TableColumn<Poste, Void> param) {
                return new TableCell<>() {

                    private final Button btn = new Button("Voir");

                    {
                        btn.setOnAction(event -> {
                            Poste poste = getTableView().getItems().get(getIndex());
                            if (voirClicked != null) {
                                voirClicked.accept(poste);
                            }
                        });
                    }

                    @Override
                    protected void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        setGraphic(empty ? null : btn);
                    }
                };
            }
        });

        getTableView().getColumns().add(voirCol);
    }

    @Override
    protected PosteController getController() {
        return PosteControllerImpl.getInstance();
    }
}
