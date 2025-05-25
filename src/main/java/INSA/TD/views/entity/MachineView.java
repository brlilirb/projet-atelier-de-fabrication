package INSA.TD.views.entity;

import INSA.TD.config.ViewConfig;
import INSA.TD.controllers.EquipementController;
import INSA.TD.controllers.MachineController;
import INSA.TD.controllers.SuiviMaintenanceController;
import INSA.TD.controllers.implementation.EquipementControllerImpl;
import INSA.TD.controllers.implementation.MachineControllerImpl;
import INSA.TD.controllers.implementation.SuiviMaintenanceControllerImpl;
import INSA.TD.models.Fiabilite;
import INSA.TD.models.Machine;
import INSA.TD.views.entity.form.MachineForm;
import INSA.TD.views.entity.tableview.MachineTableView;
import INSA.TD.views.label.TitleBox;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

import java.util.Objects;

public class MachineView extends AbstractEntityView<Machine> {

    private final EquipementController equipementController;

    private VBox vbox;

    public MachineView() {
        super();
        equipementController = EquipementControllerImpl.getInstance();
        setTop(new TitleBox("Machines"));
    }

    @Override
    protected boolean checkUnique(Machine entity) {
        return Objects.isNull(equipementController.afficher(entity.getId()));
    }

    @Override
    protected MachineController getController() {
        return MachineControllerImpl.getInstance();
    }

    @Override
    protected TableView<Machine> createTableView() {
        MachineTableView machineTableView = new MachineTableView(getData());
        machineTableView.setOnVoirClicked(this::handleVoir);
        return machineTableView;
    }

    @Override
    protected MachineForm createAddForm() {
        return new MachineForm(this::addValue);
    }

    @Override
    protected Node createSpecificNode() {
        vbox = new VBox();
        vbox.setVisible(false);
        return vbox;
    }

    private void handleVoir(Machine machine) {
        Fiabilite fiabilite = getSuiviMaintenanceController().calculerFiabilite(machine.getId());

        if (fiabilite != null) {
            vbox.setSpacing(ViewConfig.DEFAULT_SPACING);
            vbox.setPadding(new Insets(ViewConfig.DEFAULT_SPACING));
            vbox.setVisible(true);
            vbox.getChildren().setAll(
                    new FiabiliteView(fiabilite, this::clearFiabiliteView)
            );
        }
    }

    private void clearFiabiliteView() {
        vbox.setSpacing(0);
        vbox.setPadding(Insets.EMPTY);
        vbox.setVisible(false);
        vbox.getChildren().clear();
    }

    private SuiviMaintenanceController getSuiviMaintenanceController() {
        return SuiviMaintenanceControllerImpl.getInstance();
    }
}
