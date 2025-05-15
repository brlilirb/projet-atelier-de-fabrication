package INSA.TD.utils;

import java.util.List;

public class StringUtils {

    private StringUtils() {
    }

    public static <E> List<String> convertToStringList(List<E> data) {
        return data.stream()
                .map(Object::toString)
                .toList();
    }
}
