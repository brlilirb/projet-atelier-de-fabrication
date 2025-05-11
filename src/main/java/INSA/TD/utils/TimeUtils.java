package INSA.TD.utils;

import java.time.LocalDateTime;

public class TimeUtils {

    private TimeUtils() {
    }

    public static LocalDateTime convertStringToLocalDateTime(String date) {
        try {
            return LocalDateTime.parse(date, ConstantesUtils.DATE_TIME_FORMATTER);
//        System.out.println("Parsed LocalDateTime: " + dateTime);
        } catch (Exception e) {
            System.err.println("Erreur lors de la conversion de la chaîne en LocalDateTime: " + e.getMessage());
        }
        return null;
    }
}
