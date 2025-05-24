package INSA.TD.views.label;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class ErrorLabel extends Label {

    public ErrorLabel() {
        setFont();
    }

    public ErrorLabel(String message) {
        super(message);
        setFont();
    }

    private void setFont() {
        setFont(Font.font("Arial", 12));
        setStyle("-fx-text-fill: red;");
    }
}