package INSA.TD.views.menu;

import INSA.TD.views.AbstractWorkerView;
import INSA.TD.views.border.CustomBorderFactory;
import INSA.TD.views.menu.button.MenuItemButton;
import INSA.TD.views.menu.button.entity.GammeButton;
import INSA.TD.views.menu.button.entity.MachineButton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MenuView extends BorderPane {

    private final boolean autorisation;

    private final Text intro = new Text("Menu");

    private final MenuItemButton machineButton = new MachineButton();
    private final MenuItemButton gammeButton = new GammeButton();

    public MenuView(AbstractWorkerView abstractWorkerView, boolean autorisation) {
        this.autorisation = autorisation;
        setBorder(CustomBorderFactory.getRightBorder());

        createListMenu();

        machineButton.setOnAction(_ -> {
            abstractWorkerView.setCenter(new VBox(10, new Text("Machine"), new Button("fezfezf")));
//            CompetenceButtonCtrl.goToClasseView(stage, autorisation);
        });

        gammeButton.setOnAction(_ -> {
            abstractWorkerView.setCenter(new VBox(10, new Text("Gamme"), new Button("mais non c'est une gamme")));
//            CompetenceButtonCtrl.goToClasseView(stage, autorisation);
        });
    }

    private void createListMenu() {
        VBox menu = new VBox();

        VBox menuLabel = new VBox(10, intro);
        menuLabel.setBorder(CustomBorderFactory.getBottomBorder());
        menuLabel.setPadding(new Insets(10));
        menuLabel.setAlignment(Pos.CENTER);

        VBox menuItemList = new VBox(10, machineButton, gammeButton);
        menuItemList.setPadding(new Insets(10));

        menu.getChildren().setAll(
                menuLabel,
                menuItemList
        );

        this.setTop(menu);
    }
}
