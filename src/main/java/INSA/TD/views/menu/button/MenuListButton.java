package INSA.TD.views.menu.button;

import INSA.TD.views.menu.button.entity.*;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static INSA.TD.config.ViewConfig.DEFAULT_MENU_SPACING;

public class MenuListButton extends VBox {

    private final Consumer<Node> consumer;

    private List<Node> menuList;

    public MenuListButton(Consumer<Node> consumer) {
        super(DEFAULT_MENU_SPACING);
        setPadding(new Insets(15));
        setFillWidth(true);

        this.consumer = consumer;

        setBasicButton();
    }

    private void setBasicButton() {
        this.menuList = getMenuList();
        getChildren().addAll(menuList);
    }

    public List<Node> getMenuList() {
        return new ArrayList<>(List.of(
                new GammeButton(consumer),
                new MachineButton(consumer),
                new OperationButton(consumer),
                new PosteButton(consumer),
                new ProduitButton(consumer)
        ));
    }

    protected void addOtherButtons(Node... buttons) {
        this.menuList.addAll(List.of(buttons));
        getChildren().addAll(buttons);
    }

    public Consumer<Node> getConsumer() {
        return consumer;
    }
}
