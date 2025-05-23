package INSA.TD.views.entity;

import INSA.TD.controllers.PosteController;
import INSA.TD.controllers.implementation.PosteControllerImpl;
import INSA.TD.models.Poste;
import INSA.TD.views.entity.tableview.PosteTableView;
import javafx.scene.Node;
import javafx.scene.control.TableView;

public class PosteView extends AbstractEntityView<Poste> {

    @Override
    protected PosteController getController() {
        return PosteControllerImpl.getInstance();
    }

    @Override
    protected TableView<Poste> createTableView() {
        return new PosteTableView(getData());
    }

    @Override
    protected Node createSpecificNode() {
        return null;
    }
}
