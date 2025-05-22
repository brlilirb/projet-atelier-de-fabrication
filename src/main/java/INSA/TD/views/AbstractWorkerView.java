package INSA.TD.views;

import INSA.TD.views.menu.MenuView;
import javafx.scene.Node;
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
        setCenter(node);
    }

    public void setMenuView(MenuView menuView) {
        this.menuView = menuView;
    }
}
