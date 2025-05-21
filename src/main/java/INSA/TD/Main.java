package INSA.TD;

import javafx.application.Application;
import javafx.stage.Stage;
import INSA.TD.views.implementation.AccueilView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Appel de AccueilView pour afficher l'interface
        AccueilView accueilView = new AccueilView();
        accueilView.start(primaryStage);  // Affichage de la vue Accueil
    }

    public static void main(String[] args) {
        launch(args);  // Lance l'application JavaFX
    }
}