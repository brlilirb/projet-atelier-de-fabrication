package INSA.TD.views.entity;

import INSA.TD.controllers.GammeController;
import INSA.TD.controllers.implementation.GammeControllerImpl;
import INSA.TD.models.Gamme;

public class GammeView extends AbstractEntityView<Gamme> {

    @Override
    protected GammeController getController() {
        return GammeControllerImpl.getInstance();
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void initSpecificTableColumns() {

    } /*TODO ajouter colonnes produit et opérations
                -> ajouter cout gamme
    */
}
