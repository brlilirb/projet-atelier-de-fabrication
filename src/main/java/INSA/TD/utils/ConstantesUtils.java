package INSA.TD.utils;

import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

public class ConstantesUtils {

    public static final String SPACE = " ";
    public static final String SLASH = "/";
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");
    public static final String START_TIME = "06:00";
    public static final String END_TIME = "20:00";

    public static final Locale DEFAULT_LOCALE = Locale.FRANCE;

    public static final NumberFormat NUMBER_FORMAT = NumberFormat.getCurrencyInstance(DEFAULT_LOCALE);
    public static final NumberFormat PERCENT_FORMAT = NumberFormat.getPercentInstance(DEFAULT_LOCALE);

    public static final AtomicLong SUIVI_MAINTENANCE_ID = new AtomicLong(0);

    public static final double DEFAULT_WIDTH = 1000;
    public static final double DEFAULT_HEIGHT = 600;

    private ConstantesUtils() {
    }

}
