package INSA.TD.views.entity;

import INSA.TD.controllers.MachineController;
import INSA.TD.controllers.implementation.MachineControllerImpl;
import INSA.TD.models.Machine;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.NumberStringConverter;

public class MachineView extends AbstractEntityView<Machine> {

    @Override
    @SuppressWarnings("unchecked")
    protected void initSpecificTableColumns() {
        // TODO comment faire pour etatMachine
        TableColumn<Machine, String> descriptionCol = initDescriptionColumn();
        TableColumn<Machine, String> typeCol = initTypeColumn();
        TableColumn<Machine, Number> coutCol = initCoutColumn();
        TableColumn<Machine, Number> abscisseCol = initAbscisse();
        TableColumn<Machine, Number> ordonneeCol = initOrdonnee();

        getTableView().getColumns().addAll(
                descriptionCol,
                typeCol,
                coutCol,
                abscisseCol,
                ordonneeCol
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
        coutCol.setCellValueFactory(data -> new SimpleFloatProperty(data.getValue().getCout()));
        coutCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        coutCol.setOnEditCommit(event -> event.getRowValue().getCoordonnee().setAbscisse(event.getNewValue().floatValue()));
        return coutCol;
    }

    protected TableColumn<Machine, Number> initOrdonnee() {
        TableColumn<Machine, Number> coutCol = new TableColumn<>("Ordonnée");
        coutCol.setCellValueFactory(data -> new SimpleFloatProperty(data.getValue().getCout()));
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

    @Override
    protected MachineController getController() {
        return MachineControllerImpl.getInstance();
    }
}
