package INSA.TD.views.label;

import INSA.TD.config.ViewConfig;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class TitleBox extends VBox {

    public TitleBox(String title) {
        super(ViewConfig.DEFAULT_SPACING, new H1TitleLabel(title));
        setPadding(new Insets(ViewConfig.DEFAULT_SPACING));
    }
}
