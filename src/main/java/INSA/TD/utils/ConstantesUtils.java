package INSA.TD.utils;

import java.time.format.DateTimeFormatter;

public class ConstantesUtils {

    public static final String SPACE = " ";
    public static final String SLASH = "/";
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");
    public static final String START_TIME = "06:00";
    public static final String END_TIME = "20:00";

    public static final double DEFAULT_WIDTH = 1000;
    public static final double DEFAULT_HEIGHT = 600;

    private ConstantesUtils() {
    }

}
