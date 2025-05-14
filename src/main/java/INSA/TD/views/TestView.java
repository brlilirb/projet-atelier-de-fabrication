package INSA.TD.views;

import INSA.TD.controllers.implementation.ButtonController;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage ;
import javafx.scene.text.Text;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.application.Application;

public class TestView extends MenuView { // deviendra une classe abstraite pour faire hériter les autres
    private Text intro = new Text ("Menu");
    private Button testButton = new Button("test");
    private Button modifierButton = new Button("modifier");
    private Button sauvegarderButton = new Button("sauvegarder");

    public TestView(Stage stage,boolean modifiable, boolean autorisation){
        BorderPane root = new BorderPane();

       VBox menu= new VBox( 10, intro, testButton );
        menu.setPadding(new Insets(10)); // pour un petit décalage du bord

        if((modifiable == false) && (autorisation == true)) {
            HBox modifierBox = new HBox(modifierButton);
            modifierBox.setAlignment(Pos.BOTTOM_RIGHT);
            modifierBox.setPadding(new Insets(10));

            Label message = new Label("Vous ne pouvez pas modifiez");
            HBox mot = new HBox(message);
            mot.setAlignment(Pos.BOTTOM_CENTER);
            //BorderPane root = new BorderPane();
            root.setTop(menu);
            root.setBottom(modifierBox);
            root.setCenter(mot);

            ButtonController menuController=new ButtonController();
            modifierButton.setOnAction(event -> {
                ButtonController.goToModifier( stage , modifiable, autorisation);
            });

        } else if ((modifiable == true) && (autorisation == true)) {
            HBox sauvegarderBox = new HBox(sauvegarderButton);
            sauvegarderBox.setAlignment(Pos.BOTTOM_RIGHT);
            sauvegarderBox.setPadding(new Insets(10));

            Label message = new Label("Vous pouvez modifiez");
            HBox mot = new HBox(message);
            mot.setAlignment(Pos.BOTTOM_CENTER);
            //BorderPane root = new BorderPane();
            root.setTop(menu);
            root.setBottom(sauvegarderBox);
            root.setCenter(mot);

            ButtonController menuController=new ButtonController();
            sauvegarderButton.setOnAction(event -> {
                ButtonController.goToSauvegarder( stage , modifiable, autorisation);
            });

        } else {
            Label message = new Label("Vous n'avez pas les autorisations pour modifier");
            HBox mot = new HBox(message);
            mot.setAlignment(Pos.BOTTOM_CENTER);

            root.setTop(menu);
            root.setCenter(mot);
        }

        Scene scene = new Scene(root, 1000, 600);
        stage.setScene(scene);
        stage.setTitle("test");
        stage.show();
    }
}
