package INSA.TD.views.implementation;

import INSA.TD.controllers.implementation.ButtonController;
import INSA.TD.views.implementation.button.SaveButton;
import INSA.TD.views.implementation.button.UpdateButton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public abstract class AbstractView {

    protected Button modifierButton = new UpdateButton();
    protected Button sauvegarderButton = new SaveButton();


    public BorderPane AbstractModifierView(Stage stage, boolean modifiable, boolean autorisation) {
        BorderPane root = new BorderPane();
        root = ModifierVisible(root, modifiable, autorisation);
        root = AffichageClasse(root, modifiable, autorisation);
        if (autorisation) {
            if (modifiable) {
                modifierButton.setOnAction(event -> {
                    ButtonController.goToSauvegarder(stage, autorisation);
                });
            } else {
                sauvegarderButton.setOnAction(event -> {
                    ButtonController.goToModifier(stage, autorisation);
                });
            }
        }
        return root;
    }

    public BorderPane AffichageClasse(BorderPane root, boolean modifiable, boolean autorisation) {
        if (!autorisation) {
            Label message = new Label("Vous n'avez pas les autorisations pour modifier");
            HBox mot = new HBox(message);
            mot.setAlignment(Pos.BOTTOM_CENTER);
            root.setCenter(mot);
        } else if (modifiable) {
            Label message = new Label("Vous pouvez modifiez");
            HBox mot = new HBox(message);
            mot.setAlignment(Pos.BOTTOM_CENTER);
            root.setCenter(mot);
        } else {
            Label message = new Label("Vous ne pouvez pas modifiez");
            HBox mot = new HBox(message);
            mot.setAlignment(Pos.BOTTOM_CENTER);
            root.setCenter(mot);
        }
        return root;
    }

    public BorderPane ModifierVisible(BorderPane root, boolean modifiable, boolean autorisation) {
        if (autorisation == false) {
            root = MenuView.ListMenu(root);
        } else if (modifiable == true) {
            root = MenuView.ListMenu(root);
            HBox sauvegarderBox = new HBox(sauvegarderButton);
            sauvegarderBox.setAlignment(Pos.BOTTOM_RIGHT);
            sauvegarderBox.setPadding(new Insets(10));
            root.setBottom(sauvegarderBox);
        } else {
            root = MenuView.ListMenu(root);
            HBox modifierBox = new HBox(modifierButton);
            modifierBox.setAlignment(Pos.BOTTOM_RIGHT);
            modifierBox.setPadding(new Insets(10));
            root.setBottom(modifierBox);
        }
        return root;
    }

}
