package INSA.TD.views.menu.button.entity;

import INSA.TD.views.entity.EntityViewFactory;
import INSA.TD.views.menu.button.MenuItemButton;
import javafx.scene.Node;

import java.util.function.Consumer;

public class OperationButton extends MenuItemButton {

    public OperationButton(Consumer<Node> consumer) {
        super(
                "Opération",
                consumer
        );
    }

    @Override
    protected Node createNode() {
        return EntityViewFactory.createOperationView();
    }
}
