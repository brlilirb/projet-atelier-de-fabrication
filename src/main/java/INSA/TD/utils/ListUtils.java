package INSA.TD.utils;

import INSA.TD.models.AbstractIdentity;

import java.util.List;
import java.util.stream.Collectors;

public class ListUtils {

    private ListUtils() {
    }

    public static <E extends AbstractIdentity> String listToString(List<E> list, String delimiter) {
        return list.stream()
                .map(E::getId)
                .collect(Collectors.joining(delimiter));
    }

    public static <E extends AbstractIdentity> String listToString(List<E> list) {
        return listToString(list, ConstantesUtils.SLASH);
    }
}
