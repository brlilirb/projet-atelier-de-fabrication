package INSA.TD.views.entity.tableview;

import INSA.TD.models.Poste;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;

import java.util.function.Consumer;

public class PosteTableView extends AbstractEntityTableView<Poste> {

    private Consumer<Poste> voirClicked;

    public PosteTableView(ObservableList<Poste> data) {
        super(data);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void initSpecificTableColumns() {
        TableColumn<Poste, String> descriptionCol = initDescriptionColumn();

        getColumns().addAll(descriptionCol);
    }//TODO rajouter liste machines

    protected TableColumn<Poste, String> initDescriptionColumn() {
        TableColumn<Poste, String> descriptionCol = new TableColumn<>("Description");
        descriptionCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDesignation()));
        descriptionCol.setCellFactory(TextFieldTableCell.forTableColumn());
        descriptionCol.setOnEditCommit(event -> event.getRowValue().setDesignation(event.getNewValue()));
        return descriptionCol;
    }

    protected TableColumn<Poste, Void> initVoirColumn() {
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
        return voirCol;
    }

    public void setOnVoirClicked(Consumer<Poste> onVoirClicked) {
        this.voirClicked = onVoirClicked;
    }
}
