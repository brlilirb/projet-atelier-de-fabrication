package INSA.TD.views.entity;

import INSA.TD.controllers.MachineController;
import INSA.TD.controllers.implementation.MachineControllerImpl;
import INSA.TD.models.Machine;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.NumberStringConverter;
import INSA.TD.views.menu.MenuView;

public class MachineView extends AbstractEntityView<Machine> {

    @Override
    @SuppressWarnings("unchecked")
    protected void initSpecificTableColumns() {
        // TODO comment faire pour coordonées et etatMachine
        TableColumn<Machine, String> descriptionCol = initDescriptionColumn();
        TableColumn<Machine, Number> coutCol = initCoutColumn();
        TableColumn<Machine, String> typeCol = initTypeColumn();

        getTableView().getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);// permet de selectionné plusieurs ligne en m^me temps
        getTableView().setEditable(MenuView.isAutorisation()); // TODO pensez à le mettre sans tous les table car autorsie ou non les modifications

        getTableView().getColumns().addAll(descriptionCol, coutCol, typeCol);
    }

    protected TableColumn<Machine, Number> initCoutColumn() {
        TableColumn<Machine, Number> coutCol = new TableColumn<>("Cout");
        coutCol.setCellValueFactory(data -> new SimpleFloatProperty(data.getValue().getCout()));
        coutCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        coutCol.setOnEditCommit(event -> {
            event.getRowValue().setCout(event.getNewValue().floatValue());
        });
        return coutCol;
    }

    protected TableColumn<Machine, String> initDescriptionColumn() {
        TableColumn<Machine, String> descriptionCol = new TableColumn<>("Description");
        descriptionCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDesignation()));
        descriptionCol.setCellFactory(TextFieldTableCell.forTableColumn());
        descriptionCol.setOnEditCommit(event -> {
            event.getRowValue().setDesignation(event.getNewValue());
        });
        return descriptionCol;
    }

    protected TableColumn<Machine, String> initTypeColumn() {
        TableColumn<Machine, String> typeCol = new TableColumn<>("Type");
        typeCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getType()));
        typeCol.setCellFactory(TextFieldTableCell.forTableColumn());
        typeCol.setOnEditCommit(event -> {
            event.getRowValue().setType(event.getNewValue());
        });
        return typeCol;
    }

    @Override
    protected MachineController getController() {
        return MachineControllerImpl.getInstance();
    }
}
