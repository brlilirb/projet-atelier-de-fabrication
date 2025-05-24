package INSA.TD.utils;

import INSA.TD.models.Machine;
import INSA.TD.models.Operation;
import INSA.TD.models.etat.machine.EtatMachine;
import javafx.util.StringConverter;

import java.time.LocalDate;

public class StringConverterUtils {

    private StringConverterUtils() {
    }

    public static StringConverter<LocalDate> toLocalDateStringConverter() {
        return new StringConverter<>() {
            @Override
            public String toString(LocalDate date) {
                return date != null ? date.format(ConstantesUtils.DATE_FORMATTER) : "";
            }

            @Override
            public LocalDate fromString(String string) {
                return (string == null || string.isEmpty()) ? null : LocalDate.parse(string, ConstantesUtils.DATE_FORMATTER);
            }
        };
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

    public static StringConverter<Machine> toMachineStringConverter() {
        return new StringConverter<>() {
            @Override
            public String toString(Machine entity) {
                return entity == null ? "" : entity.getId();
            }

            @Override
            public Machine fromString(String string) {
                // Not used since we're working with objects
                return null;
            }
        };
    }

    public static StringConverter<Operation> toOperationStringConverter() {
        return new StringConverter<>() {
            @Override
            public String toString(Operation entity) {
                return entity == null ? "" : entity.getId();
            }

            @Override
            public Operation fromString(String string) {
                // Not used since we're working with objects
                return null;
            }
        };
    }

    public static StringConverter<Boolean> toOperateurEtatStringConverter() {
        return new StringConverter<>() {
            @Override
            public String toString(Boolean value) {
                return Boolean.TRUE.equals(value) ? "Libre" : "Indisponible";
            }

            @Override
            public Boolean fromString(String string) {
                return "Libre".equals(string);
            }
        };
    }
}
