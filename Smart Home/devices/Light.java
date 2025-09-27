package devices;

public class Light extends Device {
    private boolean isOn = false;

    public Light(int id) {
        super(id, "Light");
    }

    @Override
    public void turnOn() {
        isOn = true;
    }

    @Override
    public void turnOff() {
        isOn = false;
    }

    @Override
    public String getStatus() {
        return "Light " + id + " is " + (isOn ? "On" : "Off");
    }
}
