package INSA.TD.services.implementation;

import INSA.TD.models.AbstractIdentity;
import INSA.TD.models.SuiviMaintenance;
import INSA.TD.services.SuiviService;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public abstract class AbstractSuiviService<T extends AbstractIdentity> extends EntityService<T> implements SuiviService {

    @Override
    public void addNoExistData(List<SuiviMaintenance> data) {
        addAll(getNoExistingReferenceList(data));
    }

    private List<T> getNoExistingReferenceList(List<SuiviMaintenance> data) {
        return data.stream()
                .map(getReference())
                .filter(Predicate.not(this::existById))
                .distinct()
                .map(createNewEntity())
                .toList();
    }

    abstract Function<SuiviMaintenance, String> getReference();

    abstract Function<String, T> createNewEntity();
}
