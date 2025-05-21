package INSA.TD.views.entity;

public class EntityViewFactory {

    public static GammeView createGammeView() {
        return new GammeView();
    }

    public static MachineView createMachineView() {
        return new MachineView();
    }

    public static OperateurView createOperateurView() {
        return new OperateurView();
    }

    public static OperationView createOperationView() {
        return new OperationView();
    }

    public static PosteView createPosteView() {
        return new PosteView();
    }

    public static ProduitView createProduitView() {
        return new ProduitView();
    }

    public static SuiviMaintenanceView createSuiviMaintenanceView() {
        return new SuiviMaintenanceView();
    }
}
