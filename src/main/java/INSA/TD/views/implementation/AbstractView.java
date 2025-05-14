package INSA.TD.views.implementation;

import INSA.TD.controllers.implementation.ButtonController;
import javafx.scene.control.Button;
import javafx.stage.Stage ;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;

public abstract class AbstractView {

    //protected Text intro = new Text ("Menu");
    //protected Button testButton = new Button("test");
    protected Button modifierButton = new Button("modifier");
    protected Button sauvegarderButton = new Button("sauvegarder");



    public BorderPane AbstractModifierView(Stage stage, boolean modifiable, boolean autorisation){
        BorderPane root= new BorderPane();
        root = ModifierVisible(root,modifiable,autorisation);
        if (autorisation==false){
            Label message = new Label("Vous n'avez pas les autorisations pour modifier");
            HBox mot = new HBox(message);
            mot.setAlignment(Pos.BOTTOM_CENTER);
            root.setCenter(mot);

        } else if (modifiable==true) {

            Label message = new Label("Vous pouvez modifiez");
            HBox mot = new HBox(message);
            mot.setAlignment(Pos.BOTTOM_CENTER);
            root.setCenter(mot);

            ButtonController menuController=new ButtonController();
            sauvegarderButton.setOnAction(event -> {
                ButtonController.goToSauvegarder( stage, modifiable, autorisation);
            });

        } else {


            Label message = new Label("Vous ne pouvez pas modifiez");
            HBox mot = new HBox(message);
            mot.setAlignment(Pos.BOTTOM_CENTER);
            root.setCenter(mot);

            ButtonController menuController=new ButtonController();
            modifierButton.setOnAction(event -> {
                ButtonController.goToModifier( stage , modifiable, autorisation);
            });
        }
        return root;
    }

    public BorderPane ModifierVisible(BorderPane root, boolean modifiable, boolean autorisation){
        if(autorisation==false){
            root = MenuView.ListMenu(root);
        } else if (modifiable==true){
            root = MenuView.ListMenu(root);
            HBox sauvegarderBox = new HBox(sauvegarderButton);
            sauvegarderBox.setAlignment(Pos.BOTTOM_RIGHT);
            sauvegarderBox.setPadding(new Insets(10));
            root.setBottom(sauvegarderBox);
        }else{
            root = MenuView.ListMenu(root);
            HBox modifierBox = new HBox(modifierButton);
            modifierBox.setAlignment(Pos.BOTTOM_RIGHT);
            modifierBox.setPadding(new Insets(10));
            root.setBottom(modifierBox);
        }
        return root;
    }
}
