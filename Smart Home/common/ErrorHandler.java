package common;

public class ErrorHandler {
    public static void handle(Exception e) {
        Logger.log("Error occurred: " + e.getMessage());
    }
}
