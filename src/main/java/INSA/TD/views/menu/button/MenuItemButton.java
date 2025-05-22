package INSA.TD.views.menu.button;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;

import java.util.function.Consumer;

public abstract class MenuItemButton extends Button {

    private final Consumer<Node> _consumer;

    public MenuItemButton(String text, Consumer<Node> consumer) {
        super(text);
        this._consumer = consumer;

        setWrapText(true);
        setMaxWidth(Double.MAX_VALUE);

        initAction();
    }

    public void initAction() {
        setOnAction(getEventHandler());
    }

    private EventHandler<ActionEvent> getEventHandler() {
        return _ -> _consumer.accept(createNode());
    }

    protected abstract Node createNode();
}
