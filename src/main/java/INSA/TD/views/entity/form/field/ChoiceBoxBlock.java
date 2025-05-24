package INSA.TD.views.entity.form.field;

import INSA.TD.views.entity.form.field.textfield.CustomChoiceBox;
import INSA.TD.views.label.TitleLabel;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;

public class ChoiceBoxBlock<T> extends VBox {

    private final Label label;
    private final CustomChoiceBox<T> choiceBox;

    public ChoiceBoxBlock(String label,
                          ObservableList<T> items) {
        this.label = new TitleLabel(label);
        choiceBox = new CustomChoiceBox<>(items);
        getChildren().addAll(
                this.label,
                choiceBox
        );
    }

    public ChoiceBoxBlock(String label,
                          ObservableList<T> items,
                          StringConverter<T> converter) {
        this.label = new TitleLabel(label);
        choiceBox = new CustomChoiceBox<>(items, converter);
        getChildren().addAll(
                this.label,
                choiceBox
        );
    }

    public ChoiceBoxBlock(String label,
                          ObservableList<T> items,
                          T defaultValue,
                          StringConverter<T> converter) {
        this.label = new TitleLabel(label);
        choiceBox = new CustomChoiceBox<>(items, defaultValue, converter);
        getChildren().addAll(
                this.label,
                choiceBox
        );
    }

    public Label getLabel() {
        return label;
    }

    public CustomChoiceBox<T> getChoiceBox() {
        return choiceBox;
    }

    public T getValue() {
        return getChoiceBox().getValue();
    }
}
