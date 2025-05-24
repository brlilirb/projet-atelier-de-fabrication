package INSA.TD.views;

import INSA.TD.controllers.UserController;
import INSA.TD.controllers.implementation.UserControllerImpl;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AccueilView {

    private final UserController userController;
    private final Stage stage;

    public AccueilView(Stage stage) {
        userController = UserControllerImpl.getInstance();
        this.stage = stage;
        start();
    }

    public void start() {
        // Création de la vue Accueil
        Label titre = new Label("Quelles sont vos autorisations ?");
        Button btnOuvrier = new Button("Ouvrier");
        Button btnChef = new Button("Chef d'atelier");

        btnOuvrier.setOnAction(_ -> showOuvrierComponent());
        btnChef.setOnAction(_ -> showChefComponent());

        VBox layout = new VBox(20);
        layout.getChildren().addAll(titre, btnOuvrier, btnChef);
        layout.setAlignment(Pos.CENTER);

        showDefaultView(layout);
    }

    private void showDefaultView(Parent root) {
        Scene scene = new Scene(root);
        stage.setTitle("Page d'accueil");
        stage.setScene(scene);
        stage.show();
    }

    private void showOuvrierComponent() {
        userController.createOuvrier();
        updateView(
                new OuvrierView(),
                "Ouvrier"
        );
    }

    private void showChefComponent() {
        userController.createChefAtelier();
        updateView(
                new ChefAtelierView(),
                "Chef d'atelier"
        );
    }

    private void updateView(Parent root, String title) {
        stage.getScene().setRoot(root);
        stage.setTitle(title);
    }
}
