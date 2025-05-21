package INSA.TD.controllers.implementation;

import INSA.TD.controllers.InitController;
import INSA.TD.services.SaveService;
import INSA.TD.services.implementation.SaveServiceImpl;

import java.util.Objects;

public class InitControllerImpl implements InitController {

    private static InitControllerImpl instance;

    private final SaveService saveService = SaveServiceImpl.getInstance();

    private InitControllerImpl() {
    }

    public static InitController getInstance() {
        if (Objects.isNull(instance)) {
            instance = new InitControllerImpl();
        }
        return instance;
    }

    @Override
    public void save() {
        saveService.save();
    }

    @Override
    public void load() {
        saveService.load();
    }
}
