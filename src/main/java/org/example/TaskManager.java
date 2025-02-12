package org.example;

import java.util.ArrayList;

public class TaskManager {
    private final ArrayList<Task> tasks;

    TaskManager() {
        this.tasks = new ArrayList<>();
    }

    TaskManager(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task) {
        for (Task t : tasks) {
            if (t.getId() == task.getId()) {
                System.out.println("Task already exists");
                return;
            }
        }
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public void removeTask(int id) {
        tasks.removeIf(task -> task.getId() == id);
    }

    public void removeTask(String name) {
        tasks.removeIf(task -> task.getName().equals(name));
    }

    @Override
    public String toString() {
        System.out.println("Tasks:");
        for (Task task : tasks) {
            System.out.println(task);
        }
        return "";
    }
}
