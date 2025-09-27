package observer;

import devices.Device;
import java.util.*;

public class SmartHomeHub implements Subject {
    private List<Device> devices = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    public void addDevice(Device device) {
        devices.add(device);
        notifyObservers(device.getType() + " with ID " + device.getId() + " added.");
    }

    public void removeDevice(int id) {
        devices.removeIf(d -> d.getId() == id);
        notifyObservers("Device with ID " + id + " removed.");
    }

    public Device getDeviceById(int id) {
        return devices.stream().filter(d -> d.getId() == id).findFirst().orElse(null);
    }

    public void showStatus() {
        for (Device d : devices) {
            System.out.println(d.getStatus());
        }
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer o : observers) {
            o.update(message);
        }
    }
}