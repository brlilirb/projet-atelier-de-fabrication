package INSA.TD.views.menu;

import INSA.TD.views.AbstractWorkerView;
import INSA.TD.views.border.CustomBorderFactory;
import INSA.TD.views.menu.button.MenuListButton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.function.Consumer;

import static INSA.TD.config.ViewConfig.DEFAULT_SPACING;
import static INSA.TD.config.ViewConfig.MENU_WIDTH;

public class MenuView extends BorderPane {

    private final boolean autorisation;  // TODO remove

    private final AbstractWorkerView abstractWorkerView;

    private MenuListButton menuListButton;

    private final Text intro = new Text("Menu");

    public MenuView(AbstractWorkerView abstractWorkerView, boolean autorisation) {
        this.autorisation = autorisation;
        this.abstractWorkerView = abstractWorkerView;

        setBorder(CustomBorderFactory.getRightBorder());

        createListMenu();
    }

    private void createListMenu() {
        VBox menu = new VBox();
        menu.setFillWidth(true);
        menu.setPrefWidth(MENU_WIDTH);

        VBox menuLabel = new VBox(DEFAULT_SPACING, intro);
        menuLabel.setBorder(CustomBorderFactory.getBottomBorder());
        menuLabel.setPadding(new Insets(DEFAULT_SPACING));
        menuLabel.setAlignment(Pos.CENTER);

        createMenuListButton();

        menu.getChildren().setAll(
                menuLabel,
                menuListButton
        );

        this.setTop(menu);
    }

    protected void createMenuListButton() {
        setMenuListButton(new MenuListButton(getSetParent()));
    }

    protected Consumer<Node> getSetParent() {
        return abstractWorkerView::setBodyView;
    }

    public boolean isAutorisation() { // TODO remove autorisation
        return autorisation;
    }

    public void setMenuListButton(MenuListButton menuListButton) {
        this.menuListButton = menuListButton;
    }
}
