package INSA.TD.views.implementation;

import INSA.TD.controllers.implementation.AutorisationButtonCtrl;
import INSA.TD.controllers.implementation.ButtonController;

import INSA.TD.controllers.implementation.CompetenceButtonCtrl;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;

import javax.swing.border.Border;

public class MenuView {

    protected boolean modifiable;
    protected boolean autorisation;     // à voir car je pense que Adil les a déjà set

    private static Text intro = new Text("Menu");
    private static Button CompetenceBouton = new Button("Competence");   // il faudra remplacer test par tous nos onglets
    // il faut ajouter private static Button CompetenceBouton = new Button("Competence"); pour toutes les classes

    public MenuView( Stage stage,boolean modifiable,boolean autorisation) {

        BorderPane root = new BorderPane();
        root = ListMenu(root);

        CompetenceButtonCtrl competence=new CompetenceButtonCtrl();
        CompetenceBouton.setOnAction(event -> {
            CompetenceButtonCtrl.goToClasseView( stage , modifiable, autorisation);
        });

        Scene scene = new Scene(root, 1000, 600);
        stage.setTitle("menu");
        stage.setScene(scene);
        stage.show();
    }
    public static BorderPane ListMenu(BorderPane root) {  // quand on aura plus de classe il faudra rajouter boolean autorisation et les boutons qui vont avec en bas de l'écran
        VBox menu = new VBox(10, intro, CompetenceBouton); // a voir si on peut mettre une liste dans la méthode Vbox
        menu.setPadding(new Insets(10)); // pour un petit décalage du bord
        root.setTop(menu);
        return root;
    }

}
