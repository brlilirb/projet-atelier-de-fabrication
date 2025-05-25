package INSA.TD.controllers;

import INSA.TD.models.Gamme;

public interface GammeController extends Controller<Gamme> {

    double calculerCout(Gamme gamme);

    double calculerDuree(Gamme gamme);

}
