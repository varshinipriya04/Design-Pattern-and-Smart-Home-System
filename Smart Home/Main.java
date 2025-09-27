import common.*;
import devices.*;
import factory.DeviceFactory;
import java.util.Scanner;
import observer.*;
import proxy.DeviceProxy;
import scheduler.*;

public class Main {
    public static void main(String[] args) {
        SmartHomeHub hub = new SmartHomeHub();
        Scheduler scheduler = new Scheduler();

        // Observer for notifications
        hub.addObserver(msg -> Logger.log("[Notification] " + msg));

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        // Device initialization loop
        while (true) {
            System.out.print("Do you want to add a device? (yes/no): ");
            String addDevice = sc.nextLine().trim().toLowerCase();
            if (addDevice.equals("no")) {
                break;
            } else if (addDevice.equals("yes")) {
                System.out.print("Enter Device Type (light/thermostat/door): ");
                String deviceType = sc.nextLine().trim().toLowerCase();
                System.out.print("Enter Device ID: ");
                int deviceId = sc.nextInt();
                sc.nextLine(); // consume newline

                try {
                    Device device = DeviceFactory.createDevice(deviceType, deviceId);
                    hub.addDevice(new DeviceProxy(device));
                    Logger.log(deviceType + " with ID " + deviceId + " added.");
                } catch (Exception e) {
                    ErrorHandler.handle(e);
                }
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }

        // Main menu loop
        while (running) {
            System.out.println("\n--- Smart Home Menu ---");
            System.out.println("1. Turn On Device");
            System.out.println("2. Turn Off Device");
            System.out.println("3. Show Status");
            System.out.println("4. Schedule Device");
            System.out.println("5. Add Trigger");
            System.out.println("6. Exit");
            System.out.print("Choice: ");
            
            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Device ID: ");
                        int idOn = sc.nextInt();
                        if (ValidationUtils.isValidDeviceId(idOn)) {
                            hub.getDeviceById(idOn).turnOn();
                        }
                        break;

                    case 2:
                        System.out.print("Enter Device ID: ");
                        int idOff = sc.nextInt();
                        if (ValidationUtils.isValidDeviceId(idOff)) {
                            hub.getDeviceById(idOff).turnOff();
                        }
                        break;

                    case 3:
                        hub.showStatus();
                        break;

                    case 4:
                        System.out.print("Enter Device ID: ");
                        int sid = sc.nextInt();
                        System.out.print("Enter Time (HH:MM): ");
                        String time = sc.next();
                        if (ValidationUtils.isValidTimeFormat(time)) {
                            scheduler.addSchedule(new Task(sid, time, "Turn On"));
                            scheduler.showSchedules();
                        } else {
                            Logger.log("Invalid time format!");
                        }
                        break;

                    case 5:
                        System.out.print("Enter Condition (e.g., temperature > 75): ");
                        sc.nextLine(); // consume newline
                        String condition = sc.nextLine();
                        System.out.print("Enter Action (e.g., turnOff(1)): ");
                        String action = sc.nextLine();
                        scheduler.addTrigger(new Trigger(condition, action));
                        scheduler.showTriggers();
                        break;

                    case 6:
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (Exception e) {

                ErrorHandler.handle(e);
            }
        }
        sc.close();
    }
}
