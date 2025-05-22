package INSA.TD.views.border;

import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class CustomBorderStroke extends BorderStroke {

    public CustomBorderStroke(double top, double right, double bottom, double left) {
        super(
                Color.BLACK,
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                new BorderWidths(top, right, bottom, left)
        );
    }
}
