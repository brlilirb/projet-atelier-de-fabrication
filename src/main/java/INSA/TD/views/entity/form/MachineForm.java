package INSA.TD.views.entity.form;

import INSA.TD.models.Machine;
import INSA.TD.models.etat.machine.Disponible;
import INSA.TD.models.etat.machine.EtatMachine;
import INSA.TD.utils.StringConverterUtils;
import INSA.TD.views.entity.factory.EtatMachineFactory;
import INSA.TD.views.entity.factory.TextFormatterFactory;
import INSA.TD.views.label.H1TitleLabel;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.VBox;

import java.util.Objects;
import java.util.function.Consumer;

public class MachineForm extends AbstractForm<Machine> {

    private TextField referenceTextField;
    private TextField descriptionTextField;
    private TextField typeTextField;
    private TextFormatter<Number> coutTextFormatter;
    private TextFormatter<Number> abscisseTextFormatter;
    private TextFormatter<Number> ordonneeTextFormatter;
    private ChoiceBox<EtatMachine> etatMachineChoiceBox;

    public MachineForm(Consumer<Machine> consumer) {
        super(consumer);
    }

    @Override
    protected Node initFields() {
        VBox vbox = new VBox(10);

        referenceTextField = new TextField();
        referenceTextField.setPromptText("Référence");

        descriptionTextField = new TextField();
        descriptionTextField.setPromptText("Désignation"); // TODO verification

        typeTextField = new TextField();
        typeTextField.setPromptText("Type"); // TODO verification

        TextField coutTextField = new TextField();
        coutTextField.setPromptText("Cout");
        coutTextFormatter = TextFormatterFactory.getNumberTextFormatter();
        coutTextField.setTextFormatter(coutTextFormatter);

        TextField abscisseTextField = new TextField();
        abscisseTextField.setPromptText("Abscisse");
        abscisseTextFormatter = TextFormatterFactory.getNumberTextFormatter();
        abscisseTextField.setTextFormatter(abscisseTextFormatter);

        TextField ordonneeTextField = new TextField();
        ordonneeTextField.setPromptText("Ordonnee");
        ordonneeTextFormatter = TextFormatterFactory.getNumberTextFormatter();
        ordonneeTextField.setTextFormatter(ordonneeTextFormatter);

        etatMachineChoiceBox = new ChoiceBox<>(EtatMachineFactory.getObservableEtatsMachine());
        etatMachineChoiceBox.setValue(new Disponible());
        etatMachineChoiceBox.setConverter(StringConverterUtils.toEtatMachineStringConverter());

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
        if (!Objects.isNull(referenceTextField.getText())) { //TODO finir vérification référence nulle et afficher message dans ce cas
            Machine machine = new Machine(
                    typeTextField.getText(),
                    ordonneeTextFormatter.getValue() == null ? 0 : ordonneeTextFormatter.getValue().floatValue(),
                    abscisseTextFormatter.getValue() == null ? 0 : abscisseTextFormatter.getValue().floatValue(),
                    coutTextFormatter.getValue() == null ? 0 : coutTextFormatter.getValue().floatValue(),
                    descriptionTextField.getText(),
                    referenceTextField.getText()
            );
            if (Objects.nonNull(getConsumer())) { // TODO verification
                getConsumer().accept(machine);
            }
        } else {
            this.getChildren().forEach(node -> node.setStyle("-fx-border-color: red;"));
        }

    }
}
