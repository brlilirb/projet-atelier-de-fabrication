package INSA.TD.views.menu.button.entity;

import INSA.TD.views.entity.EntityViewFactory;
import INSA.TD.views.menu.button.MenuItemButton;
import javafx.scene.Node;

import java.util.function.Consumer;

public class MachineButton extends MenuItemButton {

    public MachineButton(Consumer<Node> consumer) {
        super(
                "Machine",
                consumer
        );
    }

    @Override
    protected Node createNode() {
        return EntityViewFactory.createMachineView();
    }
}
