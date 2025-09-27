import observer.*;
import factory.DeviceFactory;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SmartHomeHub hub = new SmartHomeHub();
        Logger logger = Logger.getInstance();
        hub.addObserver(msg -> logger.log("[Notification] " + msg));

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Smart Home Menu ---");
            System.out.println("1. Add Device");
            System.out.println("2. Show Status");
            System.out.println("3. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Device Type (light/thermostat): ");
                    String type = sc.next();
                    System.out.print("Enter Device ID: ");
                    int id = sc.nextInt();
                    hub.addDevice(DeviceFactory.createDevice(type, id));
                    break;
                case 2:
                    hub.showStatus();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}
