package INSA.TD.views;

import INSA.TD.views.menu.MenuView;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;

public abstract class AbstractWorkerView extends BorderPane {

    private MenuView menuView;

    protected AbstractWorkerView() {
        this.menuView = new MenuView(this);
        initMenuView();
    }

    public void initMenuView() {
        setLeft(menuView);
    }

    public void setBodyView(Node node) {
        ScrollPane scrollPane = new ScrollPane(node);
        scrollPane.setFitToWidth(true);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        setCenter(scrollPane);
    }

    public void setMenuView(MenuView menuView) {
        this.menuView = menuView;
    }
}
