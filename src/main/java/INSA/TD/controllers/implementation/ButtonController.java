package INSA.TD.controllers.implementation;

import INSA.TD.views.implementation.MenuView;
import javafx.stage.Stage;

public class ButtonController {

    public static void goToClasseView(Stage stage, boolean modifiable, boolean autorisation){
        MenuView nStage = new MenuView(stage,modifiable,autorisation);
    }

    public static void goToModifier(Stage stage, boolean autorisation){
        MenuView nStage = new MenuView(stage, true,autorisation);
    }

    public static void goToSauvegarder(Stage stage, boolean autorisation){
        MenuView nStage = new MenuView(stage,false,autorisation);
        // ajouter système pour sauvegarder les modifications
    }
}
