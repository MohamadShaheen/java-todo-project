package org.example;

public class Task {
    private int id;
    private String name;
    private boolean completed;

    Task(int id, String name, boolean completed) {
        this.id = id;
        this.name = name;
        this.completed = completed;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public boolean getCompleted() {
        return this.completed;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + ". Name: " + this.name + ". Completed: " + this.completed + ".";
    }
}
