package INSA.TD.controllers.implementation;

import javafx.stage.Stage;
import INSA.TD.views.implementation.TestView;

public class ButtonController {

    public static void goToTestView(Stage stage, boolean modifiable, boolean autorisation){
        TestView nStage = new TestView(stage,modifiable,autorisation);
    }
    public static void goToModifier(Stage stage, boolean modifiable, boolean autorisation){
        TestView nStage = new TestView(stage,true,autorisation);
    }
    public static void goToSauvegarder(Stage stage, boolean modifiable, boolean autorisation){
        TestView nStage = new TestView(stage,false,autorisation);
        // ajouter système pour sauvegarder les modifications
    }
    public static void autorisation(Stage stage, boolean modifiable, boolean autorisation){
        TestView nStage = new TestView(stage,modifiable,autorisation);
    }

}
