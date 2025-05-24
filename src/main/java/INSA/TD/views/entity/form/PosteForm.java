package INSA.TD.views.entity.form;

import INSA.TD.controllers.MachineController;
import INSA.TD.controllers.implementation.MachineControllerImpl;
import INSA.TD.models.Machine;
import INSA.TD.models.Poste;
import INSA.TD.utils.StringConverterUtils;
import INSA.TD.views.entity.form.field.CheckBoxListBlock;
import INSA.TD.views.entity.form.field.TextFieldBlock;
import INSA.TD.views.label.H1TitleLabel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.util.Objects;
import java.util.function.Consumer;

public class PosteForm extends AbstractForm<Poste> {

    private TextFieldBlock referenceTextField;
    private TextFieldBlock descriptionTextField;
    private CheckBoxListBlock<Machine> machineListView;

    public PosteForm(Consumer<Poste> consumer) {
        super(consumer);
    }

    @Override
    protected Node initFields() {
        VBox vbox = new VBox(10);

        referenceTextField = new TextFieldBlock("Référence");

        descriptionTextField = new TextFieldBlock("Désignation");

        machineListView = new CheckBoxListBlock<>(
                "Machines",
                FXCollections.observableArrayList(getAllMachines()),
                StringConverterUtils.toMachineStringConverter()
        );
        machineListView.getCheckBoxListField().setPrefHeight(100);

        vbox.getChildren().addAll(
                new H1TitleLabel("Création poste"),
                referenceTextField,
                descriptionTextField,
                machineListView
        );
        return vbox;
    }

    @Override
    protected void handleAddAction() {
        if (!Objects.isNull(referenceTextField.getText()) && !referenceTextField.getText().isEmpty()) {
            getErrorLabel().setVisible(false);
            Poste poste = new Poste(
                    machineListView.getSelectedItems(),
                    descriptionTextField.getText(),
                    referenceTextField.getText()
            );

            if (Objects.nonNull(getConsumer())) {
                getConsumer().accept(poste);
            }
        } else {
            getErrorLabel().setText("La référence ne doit pas être vide.");
            getErrorLabel().setVisible(true);
        }
    }

    private ObservableList<Machine> getAllMachines() {
        return FXCollections.observableArrayList(getMachineController().afficherTous());
    }

    private MachineController getMachineController() {
        return MachineControllerImpl.getInstance();
    }
}
