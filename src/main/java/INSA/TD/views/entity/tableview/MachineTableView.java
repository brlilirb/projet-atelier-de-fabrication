package INSA.TD.views.entity.tableview;

import INSA.TD.controllers.SuiviMaintenanceController;
import INSA.TD.controllers.implementation.SuiviMaintenanceControllerImpl;
import INSA.TD.controllers.implementation.UserControllerImpl;
import INSA.TD.models.Fiabilite;
import INSA.TD.models.Machine;
import INSA.TD.models.User;
import INSA.TD.models.etat.machine.EtatMachine;
import INSA.TD.utils.StringConverterUtils;
import INSA.TD.views.entity.factory.EtatMachineFactory;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.converter.NumberStringConverter;

import java.util.function.Consumer;

import static INSA.TD.views.entity.factory.TableCellFactory.getFiabiliteCell;

public class MachineTableView extends AbstractEntityTableView<Machine> {

    private Consumer<Machine> voirClicked;

    public MachineTableView(ObservableList<Machine> data) {
        super(data);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void initSpecificTableColumns() {
        TableColumn<Machine, String> descriptionCol = initDescriptionColumn();
        TableColumn<Machine, String> typeCol = initTypeColumn();
        TableColumn<Machine, Number> coutCol = initCoutColumn();
        TableColumn<Machine, Number> abscisseCol = initAbscisse();
        TableColumn<Machine, Number> ordonneeCol = initOrdonnee();
        TableColumn<Machine, EtatMachine> etatMachineCol = initEtatMachineColumn();
        TableColumn<Machine, Fiabilite> fiabiliteCol = initFiabiliteColumn();
        TableColumn<Machine, Void> voirCol = initVoirColumn();

        getColumns().addAll(
                descriptionCol,
                typeCol,
                coutCol,
                abscisseCol,
                ordonneeCol,
                fiabiliteCol,
                etatMachineCol,
                voirCol
        );

        fiabiliteCol.setVisible(getUser().autorisation());
        voirCol.setVisible(getUser().autorisation());
    }

    protected TableColumn<Machine, Number> initCoutColumn() {
        TableColumn<Machine, Number> coutCol = new TableColumn<>("Cout");
        coutCol.setCellValueFactory(data -> new SimpleFloatProperty(data.getValue().getCout()));
        coutCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        coutCol.setOnEditCommit(event -> event.getRowValue().setCout(event.getNewValue().floatValue()));
        return coutCol;
    }

    protected TableColumn<Machine, Number> initAbscisse() {
        TableColumn<Machine, Number> coutCol = new TableColumn<>("Abscisse");
        coutCol.setCellValueFactory(data -> new SimpleFloatProperty(data.getValue().getCoordonnee().getAbscisse()));
        coutCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        coutCol.setOnEditCommit(event -> event.getRowValue().getCoordonnee().setAbscisse(event.getNewValue().floatValue()));
        return coutCol;
    }

    protected TableColumn<Machine, Number> initOrdonnee() {
        TableColumn<Machine, Number> coutCol = new TableColumn<>("Ordonnée");
        coutCol.setCellValueFactory(data -> new SimpleFloatProperty(data.getValue().getCoordonnee().getOrdonnee()));
        coutCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        coutCol.setOnEditCommit(event -> event.getRowValue().getCoordonnee().setOrdonnee(event.getNewValue().floatValue()));
        return coutCol;
    }

    protected TableColumn<Machine, String> initDescriptionColumn() {
        TableColumn<Machine, String> descriptionCol = new TableColumn<>("Description");
        descriptionCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDesignation()));
        descriptionCol.setCellFactory(TextFieldTableCell.forTableColumn());
        descriptionCol.setOnEditCommit(event -> event.getRowValue().setDesignation(event.getNewValue()));
        return descriptionCol;
    }

    protected TableColumn<Machine, String> initTypeColumn() {
        TableColumn<Machine, String> typeCol = new TableColumn<>("Type");
        typeCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getType()));
        typeCol.setCellFactory(TextFieldTableCell.forTableColumn());
        typeCol.setOnEditCommit(event -> event.getRowValue().setType(event.getNewValue()));
        return typeCol;
    }

    protected TableColumn<Machine, EtatMachine> initEtatMachineColumn() {
        TableColumn<Machine, EtatMachine> etatMachineColumn = new TableColumn<>("Etat");
        etatMachineColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getEtatMachine()));
        etatMachineColumn.setCellFactory(ComboBoxTableCell.forTableColumn(
                StringConverterUtils.toEtatMachineStringConverter(),
                EtatMachineFactory.getEtatMachines()
        ));
        etatMachineColumn.setOnEditCommit(event -> event.getRowValue().setEtatMachine(event.getNewValue()));
        etatMachineColumn.setMinWidth(200);
        return etatMachineColumn;
    }

    protected TableColumn<Machine, Fiabilite> initFiabiliteColumn() {
        TableColumn<Machine, Fiabilite> fiabiliteColumn = new TableColumn<>("Fiabilité");
        fiabiliteColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(
                getSuiviMaintenanceController().calculerFiabilite(data.getValue().getId())
        ));
        fiabiliteColumn.setCellFactory(column -> getFiabiliteCell());
        fiabiliteColumn.setMinWidth(200);
        return fiabiliteColumn;
    }

    protected TableColumn<Machine, Void> initVoirColumn() {
        TableColumn<Machine, Void> voirCol = new TableColumn<>("Détail fiabilité");
        voirCol.setCellFactory(new Callback<>() {
            @Override
            public TableCell<Machine, Void> call(final TableColumn<Machine, Void> param) {//définir qu'il y a un bouton dans les cellules
                return new TableCell<>() {
                    private final Button btn = new Button("Voir");

                    {
                        btn.setOnAction(event -> {
                            Machine machine = getTableView().getItems().get(getIndex());
                            if (voirClicked != null) {
                                voirClicked.accept(machine);
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

    private SuiviMaintenanceController getSuiviMaintenanceController() {
        return SuiviMaintenanceControllerImpl.getInstance();
    }

    private User getUser() {
        return UserControllerImpl.getInstance().getUser();
    }

    public void setOnVoirClicked(Consumer<Machine> onVoirClicked) {
        this.voirClicked = onVoirClicked;
    }
}
