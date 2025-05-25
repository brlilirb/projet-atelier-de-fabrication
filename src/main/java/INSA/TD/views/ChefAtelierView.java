package INSA.TD.views;

import INSA.TD.views.menu.ChefMenuView;

public class ChefAtelierView extends AbstractWorkerView {

    public ChefAtelierView(Runnable runnable) {
        super(runnable);
    }

    @Override
    public void initMenuView() {
        this.setMenuView(new ChefMenuView(this, getRunnable()));
        super.initMenuView();
    }
}
