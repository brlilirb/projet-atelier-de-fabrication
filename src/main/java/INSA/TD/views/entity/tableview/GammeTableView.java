package INSA.TD.views.entity.tableview;

import INSA.TD.controllers.GammeController;
import INSA.TD.controllers.implementation.GammeControllerImpl;
import INSA.TD.controllers.implementation.ProduitControllerImpl;
import INSA.TD.models.AbstractIdentity;
import INSA.TD.models.Gamme;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.util.Callback;

import java.util.List;
import java.util.function.Consumer;

import static INSA.TD.views.entity.factory.TableCellFactory.getCurrencyCell;

public class GammeTableView extends AbstractEntityTableView<Gamme> {

    private Consumer<Gamme> voirClicked;

    public GammeTableView(ObservableList<Gamme> data) {
        super(data);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void initSpecificTableColumns() {
        TableColumn<Gamme, String> refProduitCol = initRefProduitColumn();
        TableColumn<Gamme, Number> coutGammeCol = initCoutColumn();
        TableColumn<Gamme, Number> dureeCol = initDureeColumn();
        TableColumn<Gamme, Void> voirCol = initVoirColumn();

        getColumns().addAll(refProduitCol, coutGammeCol, dureeCol, voirCol);
    }

    private TableColumn<Gamme, String> initRefProduitColumn() {
        TableColumn<Gamme, String> refProduitCol = new TableColumn<>("Référence produit");
        refProduitCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getRefProduit()));
        refProduitCol.setCellFactory(ComboBoxTableCell.forTableColumn(getAllProduits()));
        refProduitCol.setOnEditCommit(event -> event.getRowValue().setRefProduit(event.getNewValue()));
        return refProduitCol;
    }

    private TableColumn<Gamme, Number> initCoutColumn() {
        TableColumn<Gamme, Number> coutGammeCol = new TableColumn<>("Coût");
        coutGammeCol.setCellValueFactory(data -> new SimpleDoubleProperty(getGammeController().calculerCout(data.getValue())));
        coutGammeCol.setCellFactory(_ -> getCurrencyCell());
        coutGammeCol.setPrefWidth(100);
        return coutGammeCol;
    }

    private TableColumn<Gamme, Number> initDureeColumn() {
        TableColumn<Gamme, Number> dureeCol = new TableColumn<>("Durée (en heures)");
        dureeCol.setCellValueFactory(data -> new SimpleDoubleProperty(getGammeController().calculerDuree(data.getValue())));
        dureeCol.setPrefWidth(150);
        return dureeCol;
    }

    protected TableColumn<Gamme, Void> initVoirColumn() {
        TableColumn<Gamme, Void> voirCol = new TableColumn<>("Opérations");
        voirCol.setCellFactory(new Callback<>() {
            @Override
            public TableCell<Gamme, Void> call(final TableColumn<Gamme, Void> param) {//définir qu'il y a un bouton dans les cellules
                return new TableCell<>() {
                    private final Button btn = new Button("Voir");

                    {
                        btn.setOnAction(event -> {
                            if (voirClicked != null) {
                                voirClicked.accept(getTableView().getItems().get(getIndex()));
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
        voirCol.setSortable(false);
        return voirCol;
    }

    private GammeController getGammeController() {
        return GammeControllerImpl.getInstance();
    }

    private ObservableList<String> getAllProduits() {
        return FXCollections.observableArrayList(getAllProduitIds());
    }

    private List<String> getAllProduitIds() {
        return ProduitControllerImpl.getInstance()
                .afficherTous()
                .stream()
                .map(AbstractIdentity::getId)
                .toList();
    }

    public void setOnVoirClicked(Consumer<Gamme> onVoirClicked) {
        this.voirClicked = onVoirClicked;
    }
}
