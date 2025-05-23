package INSA.TD.views.entity;

import INSA.TD.controllers.PosteController;
import INSA.TD.controllers.implementation.AbstractEntityController;
import INSA.TD.controllers.implementation.PosteControllerImpl;
import INSA.TD.models.Poste;
import INSA.TD.views.menu.MenuView;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

import java.util.List;
import java.util.function.Consumer;


public class TableauPosteView extends AbstractEntityView<Poste> {

    private Consumer<Poste> voirClicked;

    public void setOnVoirClicked(Consumer<Poste> onVoirClicked) {
        this.voirClicked = onVoirClicked;
    }

    @Override
    protected void initSpecificTableColumns() {
        // Ajoute les colonnes spécifiques du poste ici (ex: nom, type...)
        getTableView().setEditable(MenuView.isAutorisation());
        TableColumn<Poste, Void> voirCol = initVoirColumn();
        TableColumn<Poste, String> descriptionCol = initDescriptionColumn();
        getTableView().getColumns().addAll(descriptionCol,voirCol);
        if(MenuView.isAutorisation()==true){
            TableColumn<Poste,Void> supprimerCol=initSupprimerColumn();
            getTableView().getColumns().add(supprimerCol);
        }
    }

    protected TableColumn<Poste, Void> initSupprimerColumn() {
        TableColumn<Poste, Void> supprimerCol = new TableColumn<>("Supprimer");

        supprimerCol.setCellFactory(param -> new TableCell<>() {
            private final Button deleteButton = new Button();
            private final ImageView icon = new ImageView(
                    new Image(getClass().getResourceAsStream("/Image/moins.png"))
            );

            {
                icon.setFitHeight(16);
                icon.setFitWidth(16);
                icon.setPreserveRatio(true);

                deleteButton.setGraphic(icon);
                deleteButton.setStyle("-fx-background-color: transparent;"); // transparent pour n’afficher que l’image
                deleteButton.setOnAction(event -> {
                    Poste poste = getTableView().getItems().get(getIndex());
                    PosteControllerImpl.getInstance().supprimer(poste.getId());
                    updateData(PosteControllerImpl.getInstance().afficherTous());
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : deleteButton);
            }
        });

        return supprimerCol;
    }


    protected TableColumn<Poste,Void> initVoirColumn(){
        TableColumn<Poste, Void> voirCol = new TableColumn<>("Machines");
        voirCol.setCellFactory(new Callback<>() {
            @Override
            public TableCell<Poste, Void> call(final TableColumn<Poste, Void> param) {//définir qu'il y a un boutton dans les cellules
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
                    @Override // permet d'afficher le bouton que si il y a un poste sur la ligne
                    protected void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        setGraphic(empty ? null : btn);
                    }
                };
            }
        });
        return  voirCol;
    }

    protected TableColumn<Poste, String> initDescriptionColumn() {
        TableColumn<Poste, String> descriptionCol = new TableColumn<>("Description");
        descriptionCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDesignation()));
        descriptionCol.setCellFactory(TextFieldTableCell.forTableColumn());
        descriptionCol.setOnEditCommit(event -> {
            event.getRowValue().setDesignation(event.getNewValue());
            getTableView().refresh();
        });


        return descriptionCol;
    }

    public void updateData(List<Poste> postes) {
        getTableView().getItems().setAll(postes);
    }


    @Override
    protected PosteController getController() {
        return PosteControllerImpl.getInstance();
    }

}
