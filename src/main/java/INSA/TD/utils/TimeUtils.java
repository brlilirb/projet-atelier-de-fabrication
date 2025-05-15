package INSA.TD.utils;

import java.time.LocalDateTime;
import java.time.LocalTime;

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

    public static LocalTime convertStringToLocalTime(String time) {
        try {
            return LocalTime.parse(time, ConstantesUtils.TIME_FORMATTER);
//        System.out.println("Parsed LocalDateTime: " + dateTime);
        } catch (Exception e) {
            System.err.println("Erreur lors de la conversion de la chaîne en LocalDateTime: " + e.getMessage());
        }
        return null;
    }

    public static LocalTime getStartTime() {
        return convertStringToLocalTime(ConstantesUtils.START_TIME);
    }

    public static LocalTime getEndTime() {
        return convertStringToLocalTime(ConstantesUtils.END_TIME);
    }
}
