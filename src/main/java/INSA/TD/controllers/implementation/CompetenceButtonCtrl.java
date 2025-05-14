package INSA.TD.controllers.implementation;

import INSA.TD.views.implementation.CompetenceView;
import INSA.TD.views.implementation.MenuView;
import javafx.stage.Stage;

public class CompetenceButtonCtrl {

    public static void goToClasseView(Stage stage, boolean modifiable, boolean autorisation){
        CompetenceView nStage = new CompetenceView(stage,modifiable,autorisation);
    }

    public static void goToModifier(Stage stage,  boolean modifiable, boolean autorisation){
        CompetenceView nStage = new CompetenceView(stage, true,autorisation);
    }

    public static void goToSauvegarder(Stage stage, boolean modifiable, boolean autorisation){
        CompetenceView nStage = new CompetenceView(stage,false,autorisation);
        // ajouter système pour sauvegarder les modifications
    }
}
