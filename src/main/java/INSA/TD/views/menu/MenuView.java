package INSA.TD.views.menu;

import INSA.TD.views.border.CustomBorderFactory;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MenuView extends BorderPane {

    private final boolean autorisation;

    private final Text intro = new Text("Menu");
    private final Button competenceBouton = new Button("Competence");// il faudra remplacer test par tous nos onglets

    public MenuView(boolean autorisation) {
        this.autorisation = autorisation;
        setBorder(CustomBorderFactory.getRightBorder());

        createListMenu();

        competenceBouton.setOnAction(_ -> {
//            CompetenceButtonCtrl.goToClasseView(stage, autorisation);
        });
    }

    private void createListMenu() {
        VBox menu = new VBox();

        VBox menuLabel = new VBox(10, intro);
        menuLabel.setBorder(CustomBorderFactory.getBottomBorder());
        menuLabel.setPadding(new Insets(10));
        menuLabel.setAlignment(Pos.CENTER);

        VBox menuItemList = new VBox(10, competenceBouton);
        menuItemList.setPadding(new Insets(10));

        menu.getChildren().setAll(
                menuLabel,
                menuItemList
        );

        this.setTop(menu);
    }
}
