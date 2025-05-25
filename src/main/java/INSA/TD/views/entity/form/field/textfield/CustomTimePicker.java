package INSA.TD.views.entity.form.field.textfield;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CustomTimePicker extends CustomChoiceBox<String> {

    public CustomTimePicker() {
        super(null);
        setItems(getTimes());
        getSelectionModel().selectFirst();
    }

    private ObservableList<String> getTimes() {
        ObservableList<String> times = FXCollections.observableArrayList();
        for (int hour = 6; hour < 20; hour++) {
            for (int min = 0; min < 60; min += 15) { // 15-minute intervals
                times.add(String.format("%02d:%02d", hour, min));
            }
        }
        return times;
    }
}
