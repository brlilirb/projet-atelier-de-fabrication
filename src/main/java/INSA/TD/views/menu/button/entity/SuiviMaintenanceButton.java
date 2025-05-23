package INSA.TD.views.menu.button.entity;

import INSA.TD.views.entity.factory.EntityViewFactory;
import INSA.TD.views.menu.button.MenuItemButton;
import javafx.scene.Node;

import java.util.function.Consumer;

public class SuiviMaintenanceButton extends MenuItemButton {

    public SuiviMaintenanceButton(Consumer<Node> consumer) {
        super(
                "Suivi maintenance",
                consumer
        );
    }

    @Override
    protected Node createNode() {
        return EntityViewFactory.createSuiviMaintenanceView();
    }
}
