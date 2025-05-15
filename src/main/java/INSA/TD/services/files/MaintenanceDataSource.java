package INSA.TD.services.files;

import INSA.TD.services.files.filemanager.TXTDataSource;

public class MaintenanceDataSource extends AtelierDataSource {

    public static final String MAINTENANCE = "maintenance/";

    public MaintenanceDataSource() {
        super(new TXTDataSource(MAINTENANCE + "suiviMaintenance"));
    }

}
