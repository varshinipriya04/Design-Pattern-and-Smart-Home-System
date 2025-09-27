package proxy;

import devices.Device;

public class DeviceProxy extends Device {
    private Device realDevice;

    public DeviceProxy(Device device) {
        super(device.getId(), device.getType());
        this.realDevice = device;
    }

    @Override
    public void turnOn() {
        System.out.println("Proxy: Checking permissions before turning ON device " + id);
        realDevice.turnOn();
    }

    @Override
    public void turnOff() {
        System.out.println("Proxy: Checking permissions before turning OFF device " + id);
        realDevice.turnOff();
    }

    @Override
    public String getStatus() {
        return realDevice.getStatus();
    }
}
