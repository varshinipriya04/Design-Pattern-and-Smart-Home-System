package factory;

import devices.Device;
import devices.Light;
import devices.Thermostat;

public class DeviceFactory {
    public static Device createDevice(String type, int id) {
        switch (type.toLowerCase()) {
            case "light":
                return new Light(id);
            case "thermostat":
                return new Thermostat(id);
            default:
                throw new IllegalArgumentException("Unknown device type: " + type);
        }
    }
}
