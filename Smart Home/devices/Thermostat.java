package devices;

public class Thermostat extends Device {
    private int temperature = 70;

    public Thermostat(int id) {
        super(id, "Thermostat");
    }

    @Override
    public void turnOn() {
        System.out.println("Thermostat " + id + " is active.");
    }

    @Override
    public void turnOff() {
        System.out.println("Thermostat " + id + " is inactive.");
    }

    public void setTemperature(int temp) {
        this.temperature = temp;
    }

    public int getTemperature() {
        return temperature;
    }

    @Override
    public String getStatus() {
        return "Thermostat " + id + " is set to " + temperature + " degrees";
    }
}