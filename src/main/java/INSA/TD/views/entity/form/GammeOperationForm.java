package INSA.TD.views.entity.form;

import INSA.TD.controllers.implementation.OperationControllerImpl;
import INSA.TD.models.Gamme;
import INSA.TD.models.Operation;
import INSA.TD.utils.StringConverterUtils;
import INSA.TD.views.entity.form.field.CheckBoxListBlock;
import INSA.TD.views.label.H1TitleLabel;
import javafx.collections.FXCollections;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class GammeOperationForm extends AbstractForm<Gamme> {

    private CheckBoxListBlock<Operation> operationListView;

    public GammeOperationForm(Consumer<Gamme> consumer, Gamme gamme) {
        super(consumer, gamme);
    }

    @Override
    protected Node initFields() {
        VBox vbox = new VBox(10);

        operationListView = new CheckBoxListBlock<>(
                "Opérations",
                FXCollections.observableArrayList(getAllOperations()),
                StringConverterUtils.toOperationStringConverter()
        );
        operationListView.getCheckBoxListField().setPrefHeight(100);

        vbox.getChildren().addAll(
                new H1TitleLabel("Ajout d'opérations pour la gamme: " + getEntity().getId()),
                operationListView
        );

        return vbox;
    }

    @Override
    protected void handleAddAction() {
        if (!operationListView.getSelectedItems().isEmpty()) {
            getErrorLabel().setVisible(false);
            Gamme gamme = getEntity();
            gamme.getListeOperations().addAll(operationListView.getSelectedItems());

            if (Objects.nonNull(getConsumer())) {
                getConsumer().accept(gamme);
            }
        } else {
            getErrorLabel().setText("Au moins une machine doit être sélectionnée.");
            getErrorLabel().setVisible(true);
        }
    }

    private List<Operation> getAllOperations() {
        return OperationControllerImpl.getInstance()
                .afficherTous()
                .stream()
                .filter(operation -> getEntity().getListeOperations().stream().noneMatch(gammeOperation -> gammeOperation.getId().equals(operation.getId())))
                .toList();
    }
}
