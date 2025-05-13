package INSA.TD.views.implementation;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AccueilView {

    public void start(Stage stage) {
        // Titre de la page
        Label titre = new Label("Quelles sont vos autorisations ?");

        // Création des boutons
        Button btnOuvrier = new Button("Ouvrier");
        Button btnChef = new Button("Chef d'atelier");

        // Actions pour les boutons
        btnOuvrier.setOnAction(_ -> System.out.println("Ouvrier sélectionné"));
        btnChef.setOnAction(_ -> System.out.println("Chef d'atelier sélectionné"));

        // Mise en page horizontale pour les boutons
        VBox layout = new VBox(20);  // 20 pixels d'écart entre les boutons
        layout.getChildren().addAll(btnOuvrier, btnChef);
        layout.setAlignment(Pos.CENTER);  // Centre les boutons horizontalement

        // Scène
        Scene scene = new Scene(layout, 400, 200);
        stage.setTitle("Page d'accueil");
        stage.setScene(scene);
        stage.show();
    }
}

