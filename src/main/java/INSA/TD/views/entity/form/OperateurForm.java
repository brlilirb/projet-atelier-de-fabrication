package INSA.TD.views.entity.form;

import INSA.TD.models.Operateur;
import INSA.TD.utils.StringConverterUtils;
import INSA.TD.views.entity.form.field.ChoiceBoxBlock;
import INSA.TD.views.entity.form.field.TextFieldBlock;
import INSA.TD.views.label.H1TitleLabel;
import javafx.collections.FXCollections;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.util.Objects;
import java.util.function.Consumer;

public class OperateurForm extends AbstractForm<Operateur> {

    private TextFieldBlock referenceTextField;
    private TextFieldBlock prenomTextField;
    private TextFieldBlock nameField;
    private ChoiceBoxBlock<Boolean> etatChoiceBox;

    public OperateurForm(Consumer<Operateur> consumer) {
        super(consumer);
    }

    @Override
    protected Node initFields() {
        VBox vbox = new VBox(10);

        referenceTextField = new TextFieldBlock("Référence");

        prenomTextField = new TextFieldBlock("Prénom");

        nameField = new TextFieldBlock("Nom");

        etatChoiceBox = new ChoiceBoxBlock<>(
                "Etat",
                FXCollections.observableArrayList(Boolean.TRUE, Boolean.FALSE),
                true,
                StringConverterUtils.toOperateurEtatStringConverter()
        );

        vbox.getChildren().addAll(
                new H1TitleLabel("Création opérateur"),
                referenceTextField,
                nameField,
                prenomTextField,
                etatChoiceBox
        );
        return vbox;
    }

    @Override
    protected void handleAddAction() {
        if (!Objects.isNull(referenceTextField.getText()) && !referenceTextField.getText().isEmpty()) {
            getErrorLabel().setVisible(false);
            Operateur operateur = new Operateur(
                    referenceTextField.getText(),
                    nameField.getText(),
                    prenomTextField.getText(),
                    etatChoiceBox.getValue()
            );

            if (Objects.nonNull(getConsumer())) {
                getConsumer().accept(operateur);
            }
        } else {
            getErrorLabel().setText("La référence ne doit pas être vide.");
            getErrorLabel().setVisible(true);
        }
    }
}
