package INSA.TD.views.entity.form;

import INSA.TD.controllers.implementation.EquipementControllerImpl;
import INSA.TD.models.AbstractIdentity;
import INSA.TD.models.Operation;
import INSA.TD.views.entity.form.field.ChoiceBoxBlock;
import INSA.TD.views.entity.form.field.NumberTextFieldBlock;
import INSA.TD.views.entity.form.field.TextFieldBlock;
import INSA.TD.views.label.H1TitleLabel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class OperationForm extends AbstractForm<Operation> {

    private TextFieldBlock referenceTextField;
    private TextFieldBlock descriptionTextField;
    private NumberTextFieldBlock dureeOperationTextField;
    private ChoiceBoxBlock<String> refEquipementChoiceBox;

    public OperationForm(Consumer<Operation> consumer) {
        super(consumer);
    }

    @Override
    protected Node initFields() {
        VBox vbox = new VBox(10);

        referenceTextField = new TextFieldBlock("Référence");

        descriptionTextField = new TextFieldBlock("Désignation");

        dureeOperationTextField = new NumberTextFieldBlock("Durée (en heures)");

        refEquipementChoiceBox = new ChoiceBoxBlock<>(
                "Référence équipement",
                getAllEquipements()
        );
        refEquipementChoiceBox.getChoiceBox().getSelectionModel().selectFirst();

        vbox.getChildren().addAll(
                new H1TitleLabel("Création opération"),
                referenceTextField,
                descriptionTextField,
                dureeOperationTextField,
                refEquipementChoiceBox
        );
        return vbox;
    }

    @Override
    protected void handleAddAction() {
        if (!Objects.isNull(referenceTextField.getText()) && !referenceTextField.getText().isEmpty()) {
            getErrorLabel().setVisible(false);
            Operation operation = new Operation(
                    referenceTextField.getText(),
                    descriptionTextField.getText(),
                    refEquipementChoiceBox.getValue(),
                    dureeOperationTextField.getFloatValue()
            );

            if (Objects.nonNull(getConsumer())) {
                getConsumer().accept(operation);
            }
        } else {
            getErrorLabel().setText("La référence ne doit pas être vide.");
            getErrorLabel().setVisible(true);
        }
    }

    private ObservableList<String> getAllEquipements() {
        return FXCollections.observableArrayList(getAllEquipementIds());
    }

    private List<String> getAllEquipementIds() {
        return EquipementControllerImpl.getInstance()
                .afficherTous()
                .stream()
                .map(AbstractIdentity::getId)
                .toList();
    }
}
