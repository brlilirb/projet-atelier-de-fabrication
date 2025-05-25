package INSA.TD.services;

import INSA.TD.models.Poste;

public interface PosteService extends Service<Poste>, SaveService {

    void clearMachine(String refMachine);

}
