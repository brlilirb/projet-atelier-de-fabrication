package INSA.TD;

import INSA.TD.controllers.InitController;
import INSA.TD.controllers.implementation.AtelierControllerImpl;

public class Main {
    public static void main(String[] args) {

        InitController initController = new AtelierControllerImpl();
        initController.init();
    }
}