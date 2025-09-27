package observer;

import devices.Device;
import java.util.ArrayList;
import java.util.List;

public class SmartHomeHub implements Subject {
    private List<Device> devices = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    public void addDevice(Device device) {
        devices.add(device);
        notifyObservers(device.getType() + " added.");
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
    public void notifyObservers(String message) {
        for (Observer o : observers) {
            o.update(message);
        }
    }
}
