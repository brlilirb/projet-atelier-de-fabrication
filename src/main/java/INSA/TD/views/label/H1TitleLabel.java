package INSA.TD.views.label;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class H1TitleLabel extends Label {

    public H1TitleLabel(String title) {
        super(title);
        setFont(Font.font("Arial", FontWeight.BOLD, 16));
    }

}
