package INSA.TD;

import INSA.TD.views.implementation.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        MainView view = new MainView();
        Scene scene = new Scene(view.getView(), 400, 300);

        stage.setTitle("JavaFX MVC without FXML");
        stage.setScene(scene);
        stage.show();
        /*InitController initController = new AtelierControllerImpl();
        initController.init();*/
    }
}