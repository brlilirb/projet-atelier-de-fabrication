package INSA.TD.views.menu.button;

import INSA.TD.controllers.implementation.InitControllerImpl;
import INSA.TD.controllers.implementation.UserControllerImpl;
import INSA.TD.views.label.TitleLabel;
import INSA.TD.views.menu.button.entity.*;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static INSA.TD.config.ViewConfig.DEFAULT_SPACING;

public class MenuListButton extends VBox {

    private final Consumer<Node> consumer;
    private final Runnable runnable;

    private List<Node> menuList;
    private final BorderPane borderPane = new BorderPane();


    public MenuListButton(Consumer<Node> consumer, Runnable runnable) {
        super(DEFAULT_SPACING);
        setPadding(new Insets(15));
        setFillWidth(true);

        this.consumer = consumer;
        this.runnable = runnable;

        setBorderPaneButtons();
        setBasicButton();
    }

    private void setBorderPaneButtons() {
        VBox vBox = new VBox(DEFAULT_SPACING, new TitleLabel("Boutons d'actions"));
        vBox.setPadding(new Insets(20, 0, 0, 0));

        if (UserControllerImpl.getInstance().getUser().autorisation()) {
            Button button = new Button("Sauvegarder");
            button.setOnAction(_ -> InitControllerImpl.getInstance().save());
            button.setWrapText(true);
            button.setMaxWidth(Double.MAX_VALUE);
            vBox.getChildren().addAll(button);
        }

        Button profileUpdate = new Button("Changer de profil");
        profileUpdate.setOnAction(_ -> runnable.run());
        profileUpdate.setWrapText(true);
        profileUpdate.setMaxWidth(Double.MAX_VALUE);

        vBox.getChildren().addAll(profileUpdate);
        borderPane.setBottom(vBox);
    }

    private void setBasicButton() {
        this.menuList = getMenuList();
        getChildren().setAll(menuList);
    }

    public List<Node> getMenuList() {
        return new ArrayList<>(List.of(
                new MachineButton(consumer),
                new PosteButton(consumer),
                new ProduitButton(consumer),
                new OperationButton(consumer),
                new GammeButton(consumer),
                borderPane
        ));
    }

    protected void addOtherButtons(Node... buttons) {
        menuList.addAll(menuList.size() - 1, List.of(buttons));
        getChildren().setAll(menuList);
    }

    public Consumer<Node> getConsumer() {
        return consumer;
    }
}
