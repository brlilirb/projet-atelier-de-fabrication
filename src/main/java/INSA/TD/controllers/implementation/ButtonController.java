package INSA.TD.controllers.implementation;

import javafx.stage.Stage;
import INSA.TD.views.TestView;

public class ButtonController {

    public static void goToTestView(Stage stage, boolean modifiable, boolean autorisation){
        TestView nStage = new TestView(stage,modifiable,autorisation);
    }
    public static void goToModifier(Stage stage, boolean modifiable, boolean autorisation){
        TestView nStage = new TestView(stage,true,true);
    }
    public static void goToSauvegarder(Stage stage, boolean modifiable, boolean autorisation){
        TestView nStage = new TestView(stage,false,true);
        // ajouter système pour sauvegarder les modifications
    }
}
