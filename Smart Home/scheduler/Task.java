package scheduler;

public class Task {
    private int deviceId;
    private String time;
    private String command;

    public Task(int deviceId, String time, String command) {
        this.deviceId = deviceId;
        this.time = time;
        this.command = command;
    }

    @Override
    public String toString() {
        return "{device: " + deviceId + ", time: " + time + ", command: " + command + "}";
    }
}
