package INSA.TD.services.implementation;

import INSA.TD.models.Operateur;
import INSA.TD.models.SuiviMaintenance;
import INSA.TD.services.OperateurService;
import INSA.TD.services.OperateurSuiviService;

import java.util.Objects;
import java.util.function.Function;

public class OperateurServiceImpl extends AbstractSuiviService<Operateur> implements OperateurService, OperateurSuiviService {

    private static OperateurServiceImpl instance;

    private OperateurServiceImpl() {
    }

    public static OperateurService getInstance() {
        return getSingleton();
    }

    protected static OperateurSuiviService getSuiviInstance() {
        return getSingleton();
    }

    private static OperateurServiceImpl getSingleton() {
        if (Objects.isNull(instance)) {
            instance = new OperateurServiceImpl();
        }
        return instance;
    }

    @Override
    public String getExistMessage() {
        return "La référence de l'opérateur existe déjà.";
    }

    @Override
    Function<SuiviMaintenance, String> getReference() {
        return SuiviMaintenance::getOperateur;
    }

    @Override
    Function<String, Operateur> createNewEntity() {
        return Operateur::new;
    }

}
