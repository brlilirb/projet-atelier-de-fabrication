package INSA.TD.views.entity.tableview;

import INSA.TD.models.Gamme;
import javafx.collections.ObservableList;

public class GammeTableView extends AbstractTableView<Gamme> {

    public GammeTableView(ObservableList<Gamme> data) {
        super(data);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void initSpecificTableColumns() {

    } /*TODO ajouter colonnes produit et opérations
                -> ajouter cout gamme
    */
}
