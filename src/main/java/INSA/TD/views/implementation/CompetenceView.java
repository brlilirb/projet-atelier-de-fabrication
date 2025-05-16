package INSA.TD.views.implementation;

import INSA.TD.controllers.implementation.ButtonController;
import INSA.TD.controllers.implementation.CompetenceButtonCtrl;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import INSA.TD.views.implementation.MenuView;

public class CompetenceView extends AbstractView {
    public CompetenceView(Stage stage, boolean modifiable, boolean autorisation){
        BorderPane root = new BorderPane();
        root= AbstractModifierView(stage,modifiable,autorisation);
        Scene scene = new Scene(root, 1000, 600);
        stage.setScene(scene);
        stage.setTitle("Competence");
        stage.show();
    }
    @Override
    public BorderPane AbstractModifierView(Stage stage, boolean modifiable, boolean autorisation){
        BorderPane root= new BorderPane();
        root = ModifierVisible(root,modifiable,autorisation);
        root = AffichageClasse(root,modifiable,autorisation);
        if ((modifiable==true)&&(autorisation==true)) {

            CompetenceButtonCtrl menuController=new CompetenceButtonCtrl();
            sauvegarderButton.setOnAction(event -> {
                CompetenceButtonCtrl.goToSauvegarder( stage, autorisation);
            });

        } else if((modifiable==false)&&(autorisation==true)) {

            CompetenceButtonCtrl menuController=new CompetenceButtonCtrl();
            modifierButton.setOnAction(event -> {
                CompetenceButtonCtrl.goToModifier( stage, autorisation);
            });
        }
        return root;
    }
   /* @Override
    public BorderPane AbstractModifierView(Stage stage, boolean modifiable, boolean autorisation) {
        BorderPane root= new BorderPane();
        root=super.ModifierVisible(root, modifiable, autorisation);
        if (autorisation==false){
            Label message = new Label("Vous n'avez pas les autorisations pour modifier les compétences");
            HBox mot = new HBox(message);
            mot.setAlignment(Pos.BOTTOM_CENTER);
            root.setCenter(mot);

        } else if (modifiable==true) {

            Label message = new Label("Vous pouvez modifiez les compétences");
            HBox mot = new HBox(message);
            mot.setAlignment(Pos.BOTTOM_CENTER);
            root.setCenter(mot);

            CompetenceButtonCtrl menuController=new CompetenceButtonCtrl();
            sauvegarderButton.setOnAction(event -> {
                CompetenceButtonCtrl.goToSauvegarder( stage, modifiable, autorisation);
            });

        } else {


            Label message = new Label("Vous ne pouvez pas modifiez les compétences");
            HBox mot = new HBox(message);
            mot.setAlignment(Pos.BOTTOM_CENTER);
            root.setCenter(mot);

            CompetenceButtonCtrl menuController=new CompetenceButtonCtrl();
            modifierButton.setOnAction(event -> {
                CompetenceButtonCtrl.goToModifier( stage , modifiable, autorisation);
            });
        }
        return root;
    }*/
    @Override
    public BorderPane AffichageClasse(BorderPane root, boolean modifiable, boolean autorisation){
        if (autorisation==false){
            Label message = new Label("Vous n'avez pas les autorisations pour modifier compétences");
            HBox mot = new HBox(message);
            mot.setAlignment(Pos.BOTTOM_CENTER);
            root.setCenter(mot);
        } else if (modifiable==true) {
            Label message = new Label("Vous pouvez modifiez compétences");
            HBox mot = new HBox(message);
            mot.setAlignment(Pos.BOTTOM_CENTER);
            root.setCenter(mot);
        } else{
            Label message = new Label("Vous ne pouvez pas modifiez compétences");
            HBox mot = new HBox(message);
            mot.setAlignment(Pos.BOTTOM_CENTER);
            root.setCenter(mot);
        }
        return root;
    }

}
