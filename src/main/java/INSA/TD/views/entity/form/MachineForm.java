package INSA.TD.views.entity.form;

import INSA.TD.models.Machine;
import INSA.TD.models.etat.machine.Disponible;
import INSA.TD.models.etat.machine.EtatMachine;
import INSA.TD.utils.StringConverterUtils;
import INSA.TD.views.entity.factory.EtatMachineFactory;
import INSA.TD.views.entity.form.field.ChoiceBoxBlock;
import INSA.TD.views.entity.form.field.NumberTextFieldBlock;
import INSA.TD.views.entity.form.field.TextFieldBlock;
import INSA.TD.views.label.H1TitleLabel;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.util.Objects;
import java.util.function.Consumer;

public class MachineForm extends AbstractForm<Machine> {

    private TextFieldBlock referenceTextField;
    private TextFieldBlock descriptionTextField;
    private TextFieldBlock typeTextField;
    private NumberTextFieldBlock coutTextField;
    private NumberTextFieldBlock abscisseTextField;
    private NumberTextFieldBlock ordonneeTextField;
    private ChoiceBoxBlock<EtatMachine> etatMachineChoiceBox;

    public MachineForm(Consumer<Machine> consumer) {
        super(consumer);
    }

    @Override
    protected Node initFields() {
        VBox vbox = new VBox(10);

        referenceTextField = new TextFieldBlock("Référence");

        descriptionTextField = new TextFieldBlock("Désignation");

        typeTextField = new TextFieldBlock("Type");

        coutTextField = new NumberTextFieldBlock("Coût");

        abscisseTextField = new NumberTextFieldBlock("Abscisse");

        ordonneeTextField = new NumberTextFieldBlock("Ordonnée");

        etatMachineChoiceBox = new ChoiceBoxBlock<>(
                "Etat machine",
                EtatMachineFactory.getEtatMachines(),
                new Disponible(),
                StringConverterUtils.toEtatMachineStringConverter()
        );

        vbox.getChildren().addAll(
                new H1TitleLabel("Création machine"),
                referenceTextField,
                descriptionTextField,
                typeTextField,
                coutTextField,
                abscisseTextField,
                ordonneeTextField,
                etatMachineChoiceBox
        );
        return vbox;
    }

    @Override
    protected void handleAddAction() {
        if (!Objects.isNull(referenceTextField.getText()) && !referenceTextField.getText().isEmpty()) {
            getErrorLabel().setVisible(false);
            Machine machine = new Machine(
                    typeTextField.getText(),
                    ordonneeTextField.getFloatValue(),
                    abscisseTextField.getFloatValue(),
                    coutTextField.getFloatValue(),
                    descriptionTextField.getText(),
                    referenceTextField.getText(),
                    etatMachineChoiceBox.getValue()
            );

            if (Objects.nonNull(getConsumer())) {
                getConsumer().accept(machine);
            }
        } else {
            getErrorLabel().setText("La référence ne doit pas être vide.");
            getErrorLabel().setVisible(true);
        }
    }
}
