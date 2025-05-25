package INSA.TD.views.menu.button.entity;

import INSA.TD.views.entity.factory.EntityViewFactory;
import INSA.TD.views.menu.button.MenuItemButton;
import javafx.scene.Node;

import java.util.function.Consumer;

public class PosteButton extends MenuItemButton {

    public PosteButton(Consumer<Node> consumer) {
        super(
                "Poste",
                consumer
        );
    }

    @Override
    protected Node createNode() {
        return EntityViewFactory.createPosteView();
    }
}
