package INSA.TD.views.entity.form;

import INSA.TD.controllers.implementation.MachineControllerImpl;
import INSA.TD.controllers.implementation.OperationControllerImpl;
import INSA.TD.models.AbstractIdentity;
import INSA.TD.models.SuiviMaintenance;
import INSA.TD.views.entity.factory.EtatMachineFactory;
import INSA.TD.views.entity.form.field.ChoiceBoxBlock;
import INSA.TD.views.entity.form.field.DatePickerBlock;
import INSA.TD.views.entity.form.field.TimePickerBlock;
import INSA.TD.views.label.H1TitleLabel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class SuiviMaintenanceForm extends AbstractForm<SuiviMaintenance> {

    private DatePickerBlock dateTextField;
    private TimePickerBlock timePickerBlock;
    private ChoiceBoxBlock<String> referenceMachineTextField;
    private ChoiceBoxBlock<String> etatTextField;
    private ChoiceBoxBlock<String> operateurTextField;
    private ChoiceBoxBlock<String> causeTextField;

    public SuiviMaintenanceForm(Consumer<SuiviMaintenance> consumer) {
        super(consumer);
    }

    @Override
    protected Node initFields() {
        VBox vbox = new VBox(10);

        dateTextField = new DatePickerBlock("Date");

        timePickerBlock = new TimePickerBlock("Heure");

        referenceMachineTextField = new ChoiceBoxBlock<>(
                "Référence machine",
                getAllEquipements()
        );

        etatTextField = new ChoiceBoxBlock<>(
                "Etat",
                EtatMachineFactory.getEtats()
        );
        etatTextField.getChoiceBox().getSelectionModel().selectFirst();

        operateurTextField = new ChoiceBoxBlock<>(
                "Opérateur",
                getAllOperateurs()
        );
        operateurTextField.getChoiceBox().getSelectionModel().selectFirst();

        causeTextField = new ChoiceBoxBlock<>(
                "Cause",
                EtatMachineFactory.getCauses()
        );
        causeTextField.getChoiceBox().getSelectionModel().selectFirst();

        vbox.getChildren().addAll(
                new H1TitleLabel("Création suivi maintenance"),
                dateTextField,
                timePickerBlock,
                referenceMachineTextField,
                etatTextField,
                operateurTextField,
                causeTextField
        );
        return vbox;
    }

    @Override
    protected void handleAddAction() {
        if (Objects.isNull(referenceMachineTextField.getValue()) && referenceMachineTextField.getValue().isEmpty()
                && Objects.isNull(dateTextField.getDate()) && dateTextField.getDate().isEmpty()
                && Objects.isNull(timePickerBlock.getTime()) && timePickerBlock.getTime().isEmpty()
                && Objects.isNull(etatTextField.getValue()) && etatTextField.getValue().isEmpty()) {
            SuiviMaintenance suiviMaintenance = new SuiviMaintenance(
                    dateTextField.getDate(),
                    timePickerBlock.getTime(),
                    referenceMachineTextField.getValue(),
                    etatTextField.getValue(),
                    operateurTextField.getValue(),
                    causeTextField.getValue()
            );

            if (Objects.nonNull(getConsumer())) {
                getConsumer().accept(suiviMaintenance);
            }
        } else {
            getErrorLabel().setText("Tous les champs doivent être remplis.");
            getErrorLabel().setVisible(true);
        }
    }

    private ObservableList<String> getAllOperateurs() {
        return FXCollections.observableArrayList(getAllOperateurIds());
    }

    private List<String> getAllOperateurIds() {
        return OperationControllerImpl.getInstance()
                .afficherTous()
                .stream()
                .map(AbstractIdentity::getId)
                .toList();
    }

    private ObservableList<String> getAllEquipements() {
        return FXCollections.observableArrayList(getAllEquipementIds());
    }

    private List<String> getAllEquipementIds() {
        return MachineControllerImpl.getInstance()
                .afficherTous()
                .stream()
                .map(AbstractIdentity::getId)
                .toList();
    }
}
