package INSA.TD.views;

import INSA.TD.controllers.UserController;
import INSA.TD.controllers.implementation.UserControllerImpl;
import INSA.TD.models.ChefAtelier;
import INSA.TD.models.User;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public class DefaultView extends StackPane {

    private final UserController userController;

    public DefaultView() {
        userController = UserControllerImpl.getInstance();
        Font font = Font.font("Arial", FontWeight.BOLD, 32);

        VBox vbox = new VBox(10);
        Label label = new Label("Bienvenue dans l'application de gestion de l'atelier de fabrication");
        label.setFont(font);
        label.setWrapText(true);
        label.setTextAlignment(TextAlignment.CENTER); // centers wrapped lines
        label.setAlignment(Pos.CENTER);

        Label role = new Label(getTitle());
        role.setFont(font);

        vbox.getChildren().setAll(label, role);
        vbox.setAlignment(Pos.CENTER);

        getChildren().setAll(vbox);
        setPrefSize(ScrollPane.USE_COMPUTED_SIZE, ScrollPane.USE_COMPUTED_SIZE);
        setStyle("""
                    -fx-border-color: transparent;
                    -fx-focus-color: transparent;
                    -fx-faint-focus-color: transparent;
                """);
    }

    public String getTitle() {
        User user = userController.getUser();
        if (user != null) {
            if (user.personne() instanceof ChefAtelier) {
                return "Chef d'atelier";
            }
        }
        return "Ouvrier";
    }
}
