package INSA.TD.views;

import INSA.TD.controllers.implementation.ButtonController;

import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.application.Application;

public class MenuView {

    protected boolean modifiable;
    protected boolean autorisation;     // à voir car je pense que Adil les a déjà set

    private Text intro = new Text("Menu");
    private Button testButton = new Button("test");   // il faudra remplacer test par tous nos onglets


    public void start(boolean autorisation, Stage stage) {
        VBox menu = new VBox(10, intro, testButton); // a voir si on peut mettre une liste dans la méthode Vbox
        menu.setPadding(new Insets(10)); // pour un petit décalage du bord

        BorderPane root = new BorderPane();
        root.setTop(menu);

        ButtonController menuController=new ButtonController();
        testButton.setOnAction(event -> {
            ButtonController.goToTestView( stage , modifiable, autorisation);
        });

        Scene scene = new Scene(root, 1000, 600);
        stage.setTitle("menu");
        stage.setScene(scene);
        stage.show();
    }

}
