package INSA.TD;

import INSA.TD.views.implementation.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import INSA.TD.views.MenuView;
import  INSA.TD.controllers.implementation.ButtonController;
import INSA.TD.views.TestView;
import INSA.TD.models.Competence;

public class Main extends Application {
    /*public static void main(String[] args) {
        launch();
    }*/

   /* @Override
    public void start(Stage stage) throws Exception {
        MainView view = new MainView();
        Scene scene = new Scene(view.getView(), 400, 300);

        stage.setTitle("JavaFX MVC without FXML");
        stage.setScene(scene);
        stage.show();
        /*InitController initController = new AtelierControllerImpl();
        initController.init();*/



 //   @Override
    public void start(Stage primaryStage) {
        Competence model = new Competence();
        MenuView view = new MenuView();
        view.start(true,primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }//

}