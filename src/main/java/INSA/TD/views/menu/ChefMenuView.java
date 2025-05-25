package INSA.TD.views.menu;

import INSA.TD.views.AbstractWorkerView;
import INSA.TD.views.menu.button.ChefMenuListButton;

public class ChefMenuView extends MenuView {

    public ChefMenuView(AbstractWorkerView abstractWorkerView, Runnable runnable) {
        super(abstractWorkerView, runnable);
    }

    @Override
    protected void createMenuListButton() {
        setMenuListButton(new ChefMenuListButton(getSetParent(), getRunnable()));
    }
}
