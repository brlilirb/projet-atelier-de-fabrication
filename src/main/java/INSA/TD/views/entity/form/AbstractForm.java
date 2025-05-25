package INSA.TD.views.entity.form;

import INSA.TD.config.ViewConfig;
import INSA.TD.views.button.AddButton;
import INSA.TD.views.label.ErrorLabel;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.function.Consumer;


public abstract class AbstractForm<T> extends VBox {

    private Consumer<T> consumer;
    private final Button button = new AddButton();
    private final Label errorLabel = new ErrorLabel();
    private T entity;

    protected AbstractForm(Consumer<T> consumer) {
        this.consumer = consumer;
        button.setOnAction(_ -> handleAddAction());
        errorLabel.setVisible(false);
        createForm();
    }

    protected AbstractForm(Consumer<T> consumer, T entity) {
        this.entity = entity;
        this.consumer = consumer;
        button.setOnAction(_ -> handleAddAction());
        errorLabel.setVisible(false);
        createForm();
    }

    private void createForm() {
        setSpacing(ViewConfig.DEFAULT_SPACING);
        setPadding(new Insets(ViewConfig.DEFAULT_SPACING));
        setMaxWidth(500);
        setBackground(new Background(
                new BackgroundFill(Color.WHITE, new CornerRadii(10), Insets.EMPTY)
        ));
        initForm();
    }

    protected void initForm() {
        getChildren().addAll(
                initFields(),
                button,
                errorLabel
        );
    }

    public Consumer<T> getConsumer() {
        return consumer;
    }

    public Label getErrorLabel() {
        return errorLabel;
    }

    protected abstract Node initFields();

    protected abstract void handleAddAction();

    protected T getEntity() {
        return entity;
    }
}
