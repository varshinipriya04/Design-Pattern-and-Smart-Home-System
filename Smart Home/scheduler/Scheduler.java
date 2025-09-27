package scheduler;

import java.util.*;

public class Scheduler {
    private List<Task> tasks = new ArrayList<>();
    private List<Trigger> triggers = new ArrayList<>();

    public void addSchedule(Task task) {
        tasks.add(task);
    }

    public void addTrigger(Trigger trigger) {
        triggers.add(trigger);
    }

    public void showSchedules() {
        System.out.println("Scheduled Tasks: " + tasks);
    }

    public void showTriggers() {
        System.out.println("Automated Triggers: " + triggers);
    }
}
