package INSA.TD.views.entity.form;

import INSA.TD.controllers.OperationController;
import INSA.TD.controllers.implementation.OperationControllerImpl;
import INSA.TD.controllers.implementation.ProduitControllerImpl;
import INSA.TD.models.Gamme;
import INSA.TD.models.Operation;
import INSA.TD.models.Produit;
import INSA.TD.utils.StringConverterUtils;
import INSA.TD.views.entity.form.field.CheckBoxListBlock;
import INSA.TD.views.entity.form.field.ChoiceBoxBlock;
import INSA.TD.views.entity.form.field.TextFieldBlock;
import INSA.TD.views.label.H1TitleLabel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class GammeForm extends AbstractForm<Gamme> {

    private TextFieldBlock referenceTextField;
    private ChoiceBoxBlock<String> produitChoiceBox;
    private CheckBoxListBlock<Operation> operationListView;

    public GammeForm(Consumer<Gamme> consumer) {
        super(consumer);
    }

    @Override
    protected Node initFields() {
        VBox vbox = new VBox(10);

        referenceTextField = new TextFieldBlock("Référence");

        produitChoiceBox = new ChoiceBoxBlock<>(
                "Produit",
                getAllProduits()
        );
        produitChoiceBox.getChoiceBox().getSelectionModel().selectFirst();

        operationListView = new CheckBoxListBlock<>(
                "Opérations",
                getAllOperations(),
                StringConverterUtils.toOperationStringConverter()
        );
        operationListView.getCheckBoxListField().setPrefHeight(100);

        vbox.getChildren().addAll(
                new H1TitleLabel("Création gamme"),
                referenceTextField,
                produitChoiceBox,
                operationListView
        );
        return vbox;
    }

    @Override
    protected void handleAddAction() {
        if (!Objects.isNull(referenceTextField.getText()) && !referenceTextField.getText().isEmpty()) {
            getErrorLabel().setVisible(false);
            Gamme gamme = new Gamme(
                    referenceTextField.getText(),
                    new ArrayList<>(operationListView.getSelectedItems()),
                    produitChoiceBox.getValue()
            );

            if (Objects.nonNull(getConsumer())) {
                getConsumer().accept(gamme);
            }
        } else {
            getErrorLabel().setText("La référence ne doit pas être vide.");
            getErrorLabel().setVisible(true);
        }
    }

    private ObservableList<String> getAllProduits() {
        return FXCollections.observableArrayList(getAllProduitIds());
    }

    private ObservableList<Operation> getAllOperations() {
        return FXCollections.observableArrayList(getOperationController().afficherTous());
    }

    private List<String> getAllProduitIds() {
        return ProduitControllerImpl.getInstance()
                .afficherTous()
                .stream()
                .map(Produit::getId)
                .toList();
    }

    private OperationController getOperationController() {
        return OperationControllerImpl.getInstance();
    }
}
