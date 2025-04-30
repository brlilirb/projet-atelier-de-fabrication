package INSA.TD.views.implementation;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class MainView {
    private final VBox root;
    private final Label label;
    private final Button button;
//    private final MainController controller;

    public MainView() {
        label = new Label("Press the button:");
        TextField textField = new TextField();
        textField.setText("fezzefez");
        button = new Button("Click Me");

        button.setOnAction(e -> {
            label.setText("Pressed");
            System.out.println(textField.getText());
        });

        root = new VBox(15, label, textField, button);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

//        controller = new MainController(this);
//        controller.init();
    }

    public VBox getView() {
        return root;
    }

    public Label getLabel() {
        return label;
    }

    public Button getButton() {
        return button;
    }
}