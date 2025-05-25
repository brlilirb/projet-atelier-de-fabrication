package INSA.TD.views.entity;

import INSA.TD.config.ViewConfig;
import INSA.TD.models.Fiabilite;
import INSA.TD.utils.ConstantesUtils;
import INSA.TD.views.label.H1TitleLabel;
import INSA.TD.views.label.TitleLabel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class FiabiliteView extends VBox {

    public FiabiliteView(Fiabilite fiabilite, Runnable closeAction) {
        setSpacing(ViewConfig.DEFAULT_SPACING);
        setPadding(new Insets(ViewConfig.DEFAULT_SPACING));
        setMaxWidth(500);
        setBackground(new Background(
                new BackgroundFill(Color.WHITE, new CornerRadii(10), Insets.EMPTY)
        ));
        setPrefWidth(400);

        HBox hBox = new HBox(ViewConfig.DEFAULT_SPACING);
        Button closeButton = new Button("✖");
        closeButton.setOnAction(e -> closeAction.run());
        closeButton.setStyle("-fx-font-size: 14;");

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        hBox.getChildren().addAll(new H1TitleLabel("Fiabilité de la machine: " + fiabilite.reference()), spacer, closeButton);
        hBox.setAlignment(Pos.CENTER_LEFT);

        getChildren().addAll(
                hBox,
                new HBox(ViewConfig.DEFAULT_SPACING, new TitleLabel("Nombre de jours d'observation:"), new Text(fiabilite.activeDays() + " jour(s)")),
                new HBox(ViewConfig.DEFAULT_SPACING, new TitleLabel("Temps total de fonctionnement:"), new Text(fiabilite.totalUptime().toMinutes() + " min(s)")),
                new HBox(ViewConfig.DEFAULT_SPACING, new TitleLabel("Temps total d'arrêt:"), new Text(fiabilite.totalDowntime().toMinutes() + " min(s)")),
                new HBox(ViewConfig.DEFAULT_SPACING, new TitleLabel("Fiabilité:"), new Text(ConstantesUtils.PERCENT_FORMAT.format(fiabilite.fiabilite())))
        );
    }
}
