package INSA.TD.controllers;

import INSA.TD.models.User;

public interface UserController {

    User getUser();

    void createOuvrier();

    void createChefAtelier();
}
