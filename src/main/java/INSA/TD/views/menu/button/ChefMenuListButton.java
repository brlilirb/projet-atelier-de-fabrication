package INSA.TD.views.menu.button;

import INSA.TD.views.label.TitleLabel;
import INSA.TD.views.menu.button.entity.OperateurButton;
import INSA.TD.views.menu.button.entity.SuiviMaintenanceButton;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.util.function.Consumer;

import static INSA.TD.config.ViewConfig.DEFAULT_MENU_SPACING;

public class ChefMenuListButton extends MenuListButton {

    public ChefMenuListButton(Consumer<Node> consumer) {
        super(consumer);
        setOtherButtons();
    }

    private void setOtherButtons() {
        VBox vBox = new VBox(
                DEFAULT_MENU_SPACING,
                new TitleLabel("Gestion atelier"),
                new OperateurButton(getConsumer()),
                new SuiviMaintenanceButton(getConsumer())
        );

        vBox.setPadding(new Insets(20, 0, 0, 0));

        addOtherButtons(
                vBox
        );
    }
}
