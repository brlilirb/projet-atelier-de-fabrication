package INSA.TD.views.entity;

import INSA.TD.controllers.EquipementController;
import INSA.TD.controllers.PosteController;
import INSA.TD.controllers.implementation.EquipementControllerImpl;
import INSA.TD.controllers.implementation.PosteControllerImpl;
import INSA.TD.models.Poste;
import INSA.TD.views.entity.form.AbstractForm;
import INSA.TD.views.entity.tableview.PosteTableView;
import javafx.scene.Node;
import javafx.scene.control.TableView;

import java.util.Objects;

public class PosteView extends AbstractEntityView<Poste> {

    private final EquipementController equipementController;

    public PosteView() {
        super();
        equipementController = EquipementControllerImpl.getInstance();
    }

    @Override
    protected boolean checkUnique(Poste entity) {
        return Objects.isNull(equipementController.afficher(entity.getId()));
    }

    @Override
    protected PosteController getController() {
        return PosteControllerImpl.getInstance();
    }

    @Override
    protected TableView<Poste> createTableView() {
        return new PosteTableView(getData());
    }

    @Override
    protected AbstractForm<Poste> createAddForm() {
        return null;
    }

    @Override
    protected Node createSpecificNode() {
        return null;
    }
}
