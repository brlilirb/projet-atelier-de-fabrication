package INSA.TD.views.button;

import INSA.TD.views.CompetenceView;
import javafx.stage.Stage;

public class CompetenceButtonCtrl {

    public static void goToClasseView(Stage stage, boolean modifiable, boolean autorisation) {
        CompetenceView nStage = new CompetenceView(stage, modifiable, autorisation);
    }

    public static void goToModifier(Stage stage, boolean autorisation) {
        CompetenceView nStage = new CompetenceView(stage, true, autorisation);
    }

    public static void goToSauvegarder(Stage stage, boolean autorisation) {
        CompetenceView nStage = new CompetenceView(stage, false, autorisation);
        // ajouter système pour sauvegarder les modifications
    }
}
