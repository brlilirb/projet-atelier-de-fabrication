package INSA.TD.views.entity.form;

import INSA.TD.config.ViewConfig;
import INSA.TD.views.button.AddButton;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.function.Consumer;


public abstract class AbstractForm<T> extends VBox {

    private Consumer<T> consumer;
    private final Button button = new AddButton();

    protected AbstractForm() {
        setSpacing(ViewConfig.DEFAULT_SPACING);
        setPadding(new Insets(ViewConfig.DEFAULT_SPACING));
        setMaxWidth(500);
//        setBorder(getFilledBorder());
        setBackground(new Background(
                new BackgroundFill(Color.WHITE, new CornerRadii(10), Insets.EMPTY)
        ));
        initForm();
    }

    protected AbstractForm(Consumer<T> consumer) {
        this();
        this.consumer = consumer;
        button.setOnAction(_ -> handleAddAction());
    }

    protected void initForm() {
        getChildren().addAll(
                initFields(),
                button
        );
    }

    public Consumer<T> getConsumer() {
        return consumer;
    }

    protected abstract Node initFields();

    protected abstract void handleAddAction();
}
