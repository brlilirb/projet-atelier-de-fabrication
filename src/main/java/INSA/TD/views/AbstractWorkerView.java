package INSA.TD.views;

import INSA.TD.views.menu.MenuView;
import javafx.scene.layout.BorderPane;

public abstract class AbstractWorkerView extends BorderPane {

    private final boolean autorisation;

    private MenuView menuView;

    protected AbstractWorkerView() {
        this(false);
        this.menuView = new MenuView(this.autorisation);
        initMenuView();
    }

    protected AbstractWorkerView(boolean autorisation) {
        this.autorisation = autorisation;
    }

    public void initMenuView() {
        this.setLeft(menuView);
    }
}
