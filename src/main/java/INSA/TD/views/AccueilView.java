package INSA.TD.views;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static INSA.TD.utils.ConstantesUtils.DEFAULT_HEIGHT;
import static INSA.TD.utils.ConstantesUtils.DEFAULT_WIDTH;

public class AccueilView {

    private final Stage stage;

    public AccueilView(Stage stage) {
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

        updateView(
                new Scene(layout, 400, 200),
                "Page d'accueil"
        );
    }

    private void showOuvrierComponent() {
        updateView(
                new OuvrierView(stage),
                "Ouvrier"
        );
    }

    private void showChefComponent() {
        updateView(
                new ChefAtelierView(stage),
                "Chef d'atelier"
        );
    }

    private void updateView(Scene scene, String title) {
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    private void updateView(Parent root, String title) {
        updateView(
                getScene(root),
                title
        );
    }

    private Scene getScene(Parent root) {
        return new Scene(root, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
