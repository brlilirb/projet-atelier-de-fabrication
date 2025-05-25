package INSA.TD.views.entity.form;

import INSA.TD.models.Produit;
import INSA.TD.views.entity.form.field.TextFieldBlock;
import INSA.TD.views.label.H1TitleLabel;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.util.Objects;
import java.util.function.Consumer;

public class ProduitForm extends AbstractForm<Produit> {

    private TextFieldBlock referenceTextField;
    private TextFieldBlock descriptionTextField;

    public ProduitForm(Consumer<Produit> consumer) {
        super(consumer);
    }

    @Override
    protected Node initFields() {
        VBox vbox = new VBox(10);

        referenceTextField = new TextFieldBlock("Référence");

        descriptionTextField = new TextFieldBlock("Désignation");

        vbox.getChildren().addAll(
                new H1TitleLabel("Création produit"),
                referenceTextField,
                descriptionTextField
        );
        return vbox;
    }

    @Override
    protected void handleAddAction() {
        if (!Objects.isNull(referenceTextField.getText()) && !referenceTextField.getText().isEmpty()) {
            getErrorLabel().setVisible(false);
            Produit produit = new Produit(
                    referenceTextField.getText(),
                    descriptionTextField.getText()
            );

            if (Objects.nonNull(getConsumer())) {
                getConsumer().accept(produit);
            }
        } else {
            getErrorLabel().setText("La référence ne doit pas être vide.");
            getErrorLabel().setVisible(true);
        }
    }
}
