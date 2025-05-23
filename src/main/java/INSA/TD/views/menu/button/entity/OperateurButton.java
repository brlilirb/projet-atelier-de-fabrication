package INSA.TD.views.menu.button.entity;

import INSA.TD.views.entity.EntityViewFactory;
import INSA.TD.views.menu.button.MenuItemButton;
import javafx.scene.Node;

import java.util.function.Consumer;

public class OperateurButton extends MenuItemButton {

    public OperateurButton(Consumer<Node> consumer) {
        super(
                "Opérateur",
                consumer
        );
    }

    @Override
    protected Node createNode() {
        return EntityViewFactory.createOperateurView();
    }
}
