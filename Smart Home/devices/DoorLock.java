package devices;

public class DoorLock extends Device {
    private boolean locked = true;

    public DoorLock(int id) {
        super(id, "Door");
    }

    @Override
    public void turnOn() {
        locked = false;
    }

    @Override
    public void turnOff() {
        locked = true;
    }

    @Override
    public String getStatus() {
        return "Door " + id + " is " + (locked ? "Locked" : "Unlocked");
    }
}