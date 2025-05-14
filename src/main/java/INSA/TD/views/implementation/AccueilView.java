package INSA.TD.views.implementation;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AccueilView {

    public void start(Stage stage) {
        // Création de la vue Accueil
        Label titre = new Label("Quelles sont vos autorisations ?");
        Button btnOuvrier = new Button("Ouvrier");
        Button btnChef = new Button("Chef d'atelier");

        btnOuvrier.setOnAction(_ -> System.out.println("Ouvrier sélectionné"));
        btnChef.setOnAction(_ -> System.out.println("Chef d'atelier sélectionné"));

        VBox layout = new VBox(20);
        layout.getChildren().addAll(titre, btnOuvrier, btnChef);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 400, 200);
        stage.setTitle("Page d'accueil");
        stage.setScene(scene);
        stage.show();
    }
}

