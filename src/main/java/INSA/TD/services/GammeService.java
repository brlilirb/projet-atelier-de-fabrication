package INSA.TD.services;

import INSA.TD.models.Gamme;

public interface GammeService extends Service<Gamme>, SaveService {
    double calculerCout(Gamme gamme);

    double calculerDuree(Gamme gamme);

    void clearOperation(String refOperation);

    void clearProduit(String refProduit);
}
