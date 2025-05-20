package INSA.TD.views;

import INSA.TD.views.menu.MenuView;
import javafx.scene.layout.BorderPane;

public abstract class AbstractWorkerView extends BorderPane {

    private final boolean autorisation;
    private final MenuView menuView;

    protected AbstractWorkerView() {
        this(false);
    }

    protected AbstractWorkerView(boolean autorisation) {
        this.autorisation = autorisation;
        this.menuView = new MenuView(this, autorisation);
        initMenuView();
    }

    public void initMenuView() {
        setLeft(menuView);
        setRight(null);
    }
}
