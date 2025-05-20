package INSA.TD;

import INSA.TD.controllers.InitController;
import INSA.TD.controllers.implementation.InitControllerImpl;
import INSA.TD.utils.ConstantesUtils;
import INSA.TD.views.AccueilView;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        InitController initController = InitControllerImpl.getInstance();
        initController.load();

        primaryStage.setMinHeight(ConstantesUtils.DEFAULT_HEIGHT);
        primaryStage.setMinWidth(ConstantesUtils.DEFAULT_WIDTH);

        new AccueilView(primaryStage);

        initController.save();
        primaryStage.setOnCloseRequest(event -> initController.save());
    }

    public static void main(String[] args) {
        launch(args);
    }

}