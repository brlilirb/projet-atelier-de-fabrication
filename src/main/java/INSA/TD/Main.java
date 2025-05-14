package INSA.TD;

import javafx.application.Application;
import javafx.stage.Stage;
import INSA.TD.views.implementation.AcceuilView;
import INSA.TD.models.Competence;

public class Main extends Application {
       @Override
    public void start(Stage primaryStage) {
       // Competence model = new Competence();
        AcceuilView view = new AcceuilView();
        view.start(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }

}