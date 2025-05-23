package INSA.TD.views.menu;

import INSA.TD.views.AbstractWorkerView;
import INSA.TD.views.menu.button.ChefMenuListButton;

public class ChefMenuView extends MenuView {

    public ChefMenuView(AbstractWorkerView abstractWorkerView, boolean autorisation) {
        super(abstractWorkerView, autorisation);
    }

    @Override
    protected void createMenuListButton() {
        setMenuListButton(new ChefMenuListButton(getSetParent()));
    }
}
