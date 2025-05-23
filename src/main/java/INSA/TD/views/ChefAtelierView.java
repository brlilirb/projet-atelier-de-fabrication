package INSA.TD.views;

import INSA.TD.views.menu.ChefMenuView;

public class ChefAtelierView extends AbstractWorkerView {

    public ChefAtelierView() {
        super(true);
    }

    @Override
    public void initMenuView() {
        this.setMenuView(new ChefMenuView(this, true));
        super.initMenuView();
    }
}
