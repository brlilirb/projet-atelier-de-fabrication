package INSA.TD.views.menu.button.entity;

import INSA.TD.views.entity.EntityViewFactory;
import INSA.TD.views.menu.button.MenuItemButton;
import javafx.scene.Node;

import java.util.function.Consumer;

public class GammeButton extends MenuItemButton {

    public GammeButton(Consumer<Node> consumer) {
        super(
                "Gamme",
                consumer
        );
    }

    @Override
    protected Node createNode() {
        return EntityViewFactory.createGammeView();
    }
}
