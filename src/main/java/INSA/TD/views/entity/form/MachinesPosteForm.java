package INSA.TD.views.entity.form;

import INSA.TD.controllers.implementation.MachineControllerImpl;
import INSA.TD.models.Machine;
import INSA.TD.models.Poste;
import INSA.TD.utils.StringConverterUtils;
import INSA.TD.views.entity.form.field.CheckBoxListBlock;
import INSA.TD.views.label.H1TitleLabel;
import javafx.collections.FXCollections;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class MachinesPosteForm extends AbstractForm<Poste> {

    private CheckBoxListBlock<Machine> machineListView;

    public MachinesPosteForm(Consumer<Poste> consumer, Poste poste) {
        super(consumer, poste);
    }

    @Override
    protected Node initFields() {
        VBox vbox = new VBox(10);

        machineListView = new CheckBoxListBlock<>(
                "Machines",
                FXCollections.observableArrayList(getAllMachines()),
                StringConverterUtils.toMachineStringConverter()
        );
        machineListView.getCheckBoxListField().setPrefHeight(100);

        vbox.getChildren().addAll(
                new H1TitleLabel("Ajout de machines pour le poste: " + getEntity().getId()),
                machineListView
        );

        return vbox;
    }

    @Override
    protected void handleAddAction() {
        if (!machineListView.getSelectedItems().isEmpty()) {
            getErrorLabel().setVisible(false);
            Poste poste = getEntity();
            poste.getListeMachines().addAll(machineListView.getSelectedItems());

            if (Objects.nonNull(getConsumer())) {
                getConsumer().accept(poste);
            }
        } else {
            getErrorLabel().setText("Au moins une machine doit être sélectionnée.");
            getErrorLabel().setVisible(true);
        }
    }

    private List<Machine> getAllMachines() {
        return MachineControllerImpl.getInstance()
                .afficherTous()
                .stream()
                .filter(machine -> getEntity().getListeMachines().stream().noneMatch(posteMachine -> posteMachine.getId().equals(machine.getId())))
                .toList();
    }
}
