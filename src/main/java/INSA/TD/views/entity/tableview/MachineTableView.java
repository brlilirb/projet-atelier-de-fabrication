package INSA.TD.views.entity.tableview;

import INSA.TD.models.Machine;
import INSA.TD.models.etat.machine.EtatMachine;
import INSA.TD.utils.StringConverterUtils;
import INSA.TD.views.entity.factory.EtatMachineFactory;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.NumberStringConverter;

public class MachineTableView extends AbstractEntityTableView<Machine> {

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

        this.getColumns().addAll(
                descriptionCol,
                typeCol,
                coutCol,
                abscisseCol,
                ordonneeCol,
                etatMachineCol
        );
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
}
