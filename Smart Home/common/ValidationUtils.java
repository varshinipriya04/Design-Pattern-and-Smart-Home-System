package common;

public class ValidationUtils {
    public static boolean isValidDeviceId(int id) {
        return id > 0;
    }

    public static boolean isValidTimeFormat(String time) {
        return time.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]");
    }
}