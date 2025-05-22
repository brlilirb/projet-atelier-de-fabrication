package INSA.TD.views;

import INSA.TD.views.menu.ChefMenuView;

public class ChefAtelierView extends AbstractWorkerView {

    @Override
    public void initMenuView() {
        this.setMenuView(new ChefMenuView(this));
        super.initMenuView();
    }
}
