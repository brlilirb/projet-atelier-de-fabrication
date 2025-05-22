package INSA.TD;

import INSA.TD.controllers.InitController;
import INSA.TD.controllers.MachineController;
import INSA.TD.controllers.PosteController;
import INSA.TD.controllers.implementation.InitControllerImpl;
import INSA.TD.controllers.implementation.MachineControllerImpl;
import INSA.TD.controllers.implementation.PosteControllerImpl;
import INSA.TD.models.Machine;
import INSA.TD.models.Poste;
import INSA.TD.models.etat.machine.EtatMachine;
import INSA.TD.utils.ConstantesUtils;
import INSA.TD.views.AccueilView;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.List;

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