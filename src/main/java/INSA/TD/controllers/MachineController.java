package INSA.TD.controllers;

import INSA.TD.models.Fiabilite;
import INSA.TD.models.Machine;

import java.util.Map;

public interface MachineController extends Controller<Machine> {
    Map<Machine, Fiabilite> trierMachinesParFiabilite();
}
