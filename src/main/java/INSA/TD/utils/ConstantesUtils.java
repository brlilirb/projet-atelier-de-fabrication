package INSA.TD.utils;

import java.time.format.DateTimeFormatter;

public class ConstantesUtils {

    private ConstantesUtils() {
    }

    public static final String SPACE = " ";
    public static final String SLASH = "/";
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

}
