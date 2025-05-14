package INSA.TD.views.implementation;

import INSA.TD.controllers.implementation.AutorisationButtonCtrl;
import INSA.TD.controllers.implementation.ButtonController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AcceuilView {


    public void start(Stage stage) {

        boolean modifiable = false;
        // Création de la vue Accueil
        Label titre = new Label("Quelles sont vos autorisations ?");
        Button btnOuvrier = new Button("Ouvrier");
        Button btnChef = new Button("Chef d'atelier");

        btnOuvrier.setOnAction(_ -> {
            AutorisationButtonCtrl.autorisation( stage , modifiable, false);
        });
        btnChef.setOnAction(_ -> {
            AutorisationButtonCtrl.autorisation( stage , modifiable, true);
        });

        VBox layout = new VBox(20);
        layout.getChildren().addAll(titre, btnOuvrier, btnChef);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 400, 200);
        stage.setTitle("Page d'accueil");
        stage.setScene(scene);
        stage.show();
    }
}
