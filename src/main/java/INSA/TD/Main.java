package INSA.TD;

import INSA.TD.controllers.InitController;
import INSA.TD.controllers.MachineController;
import INSA.TD.controllers.implementation.InitControllerImpl;
import INSA.TD.controllers.implementation.MachineControllerImpl;

public class Main {
    public static void main(String[] args) {

        InitController initController = InitControllerImpl.getInstance();

        /*MaintenanceServiceImpl maintenanceService = MaintenanceServiceImpl.getInstance();
        maintenanceService.addStringEvent("2025-05-10 10:23 mach_2 A");
        maintenanceService.addStringEvent("2025-05-10 12:15 mach_2 D");
        maintenanceService.addStringEvent("2025-05-10 18:41 mach_2 A");
        maintenanceService.addStringEvent("2025-05-10 19:41 mach_2 D");
        maintenanceService.addStringEvent("2025-05-12 14:16 mach_2 A");
        maintenanceService.addStringEvent("2025-05-10 17:31 mach_2 D");

        maintenanceService.addStringEvent("2025-05-10 11:23 mach_1 A");
        maintenanceService.addStringEvent("2025-05-10 12:15 mach_1 D");
        maintenanceService.addStringEvent("2025-05-10 18:41 mach_1 A");
        maintenanceService.addStringEvent("2025-05-10 21:41 mach_1 D");
        maintenanceService.addStringEvent("2025-05-12 15:16 mach_1 A");
        maintenanceService.addStringEvent("2025-05-13 17:31 mach_1 D");

        Machine mach_1 = new Machine("soudeuse", 2, 3, 300, "soudeuse3000", "mach_1");
        Machine mach_2 = new Machine("soudeuse", 2, 3, 300, "soudeuse3000", "mach_2");

        MachineService machineService = MachineServiceImpl.getInstance();

        machineService.add(mach_1);
        machineService.add(mach_2);

        initController.save();*/

        initController.load();
        /*MachineService machineService = MachineServiceImpl.getInstance();

        MaintenanceServiceImpl maintenanceService = MaintenanceServiceImpl.getInstance();

        maintenanceService.computeAllFiabilites();*/

        MachineController machineController = MachineControllerImpl.getInstance();
        machineController.afficherTous();
    }
}