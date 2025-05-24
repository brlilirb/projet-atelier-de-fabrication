package INSA.TD.controllers.implementation;

import INSA.TD.controllers.UserController;
import INSA.TD.models.ChefAtelier;
import INSA.TD.models.Operateur;
import INSA.TD.models.Personne;
import INSA.TD.models.User;

public class UserControllerImpl implements UserController {

    private static UserControllerImpl instance;

    private User user;

    private UserControllerImpl() {
    }

    public static UserController getInstance() {
        if (instance == null) {
            instance = new UserControllerImpl();
        }
        return instance;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void createOuvrier() {
        setUser(false, new Operateur());
    }

    @Override
    public void createChefAtelier() {
        setUser(true, new ChefAtelier());
    }

    private void setUser(boolean autorisation, Personne personne) {
        this.user = new User(
                autorisation,
                personne
        );
    }
}
