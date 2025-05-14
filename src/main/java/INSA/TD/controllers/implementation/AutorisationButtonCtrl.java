package INSA.TD.controllers.implementation;

import INSA.TD.views.implementation.MenuView;
import javafx.stage.Stage;

public class AutorisationButtonCtrl {
    public static void autorisation(Stage stage, boolean modifiable, boolean autorisation){
        MenuView nStage = new MenuView(stage, modifiable, autorisation);
    }
}
