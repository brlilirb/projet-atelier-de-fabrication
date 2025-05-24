package INSA.TD.views.entity;

import INSA.TD.controllers.GammeController;
import INSA.TD.controllers.implementation.GammeControllerImpl;
import INSA.TD.models.Gamme;
import INSA.TD.views.entity.form.AbstractForm;
import INSA.TD.views.entity.form.GammeForm;
import INSA.TD.views.entity.tableview.GammeTableView;
import javafx.scene.Node;
import javafx.scene.control.TableView;

public class GammeView extends AbstractEntityView<Gamme> {

    @Override
    protected GammeController getController() {
        return GammeControllerImpl.getInstance();
    }

    @Override
    protected TableView<Gamme> createTableView() {
        return new GammeTableView(getData());
    }

    @Override
    protected AbstractForm<Gamme> createAddForm() {
        return new GammeForm(this::addValue);
    }

    @Override
    protected Node createSpecificNode() {
        return null;
    }
}
