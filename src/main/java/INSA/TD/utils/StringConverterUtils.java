package INSA.TD.utils;

import INSA.TD.models.etat.machine.EtatMachine;
import javafx.util.StringConverter;

public class StringConverterUtils {

    private StringConverterUtils() {
    }

    public static StringConverter<EtatMachine> toEtatMachineStringConverter() {
        return new StringConverter<>() {
            @Override
            public String toString(EtatMachine etatMachine) {
                return etatMachine == null ? "" : etatMachine.getEtatExterne().name();
            }

            @Override
            public EtatMachine fromString(String string) {
                // Not used since we're working with objects
                return null;
            }
        };
    }
}
