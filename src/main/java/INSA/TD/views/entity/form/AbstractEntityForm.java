package INSA.TD.views.entity.form;

import INSA.TD.models.AbstractIdentity;

import java.util.function.Consumer;

public abstract class AbstractEntityForm<T extends AbstractIdentity> extends AbstractForm<T> {

    protected AbstractEntityForm(Consumer<T> consumer) {
        super(consumer);
    }
}
