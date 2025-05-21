package INSA.TD.views.menu.button.entity;

import INSA.TD.views.entity.EntityViewFactory;
import INSA.TD.views.menu.button.MenuItemButton;
import javafx.scene.Node;

import java.util.function.Consumer;

public class ProduitButton extends MenuItemButton {

    public ProduitButton(Consumer<Node> consumer) {
        super(
                "Produit",
                consumer
        );
    }

    @Override
    protected Node createNode() {
        return EntityViewFactory.createProduitView();
    }
}
