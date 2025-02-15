package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class TaskManager {
    private final ArrayList<Task> tasks = new ArrayList<>();

    TaskManager() {
        File file = new File("tasks.json");

        if (!file.exists()) {
            System.out.println("\tTasks file not found");
            var objectMapper = new ObjectMapper();
            try {
                objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, new HashMap<>());
            } catch (IOException e) {
                System.out.println("\tError writing tasks file");
            }
        } else {
            var objectMapper = new ObjectMapper();
            try {
                LinkedHashMap<String, LinkedHashMap<String, Object>> contents = objectMapper.readValue(file, new TypeReference<>() {
                });
                for (var element : contents.values()) {
                    tasks.add(new Task((int) element.get("id"), (String) element.get("name"), (boolean) element.get("completed")));
                }
            } catch (IOException e) {
                System.out.println("\tError reading tasks file");
            }
        }
    }

    public void addTask(Task task) {
        for (Task t : tasks) {
            if (t.getId() == task.getId()) {
                System.out.println("\tTask already exists");
                return;
            }
        }
        tasks.add(task);

        File file = new File("tasks.json");
        if (file.length() > 0) {
            var objectMapper = new ObjectMapper();
            try {
                LinkedHashMap<String, LinkedHashMap<String, Object>> data = objectMapper.readValue(file, new TypeReference<>() {
                });

                var taskLinkedHashMap = new LinkedHashMap<String, Object>();
                taskLinkedHashMap.put("id", task.getId());
                taskLinkedHashMap.put("name", task.getName());
                taskLinkedHashMap.put("completed", task.getCompleted());

                data.put(String.valueOf(task.getId()), taskLinkedHashMap);
                objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, data);
            } catch (IOException e) {
                System.out.println("\tError writing to tasks file");
            }
        } else {
            var objectMapper = new ObjectMapper();
            var data = new HashMap<>();
            data.put(task.getId(), task);
            try {
                objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, data);
            } catch (IOException e) {
                System.out.println("\tError writing to tasks file");
            }
        }
    }

    public void removeTask(Task task) {
        tasks.remove(task);

        File file = new File("tasks.json");
        if (file.length() == 0) {
            System.out.println("\tTask does not exist");
        } else {
            var objectMapper = new ObjectMapper();
            try {
                LinkedHashMap<String, LinkedHashMap<String, Object>> content = objectMapper.readValue(file, new TypeReference<>() {
                });
                if (!content.containsKey(String.valueOf(task.getId()))) {
                    System.out.println("\tTask does not exist");
                } else {
                    content.remove(String.valueOf(task.getId()));
                    objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, content);
                    System.out.println("\tTask removed");
                }
            } catch (IOException e) {
                System.out.println("\tError reading tasks file");
            }
        }
    }

    public void removeTask(int id) {
        Task task = new Task();

        for (Task t : tasks) {
            if (t.getId() == id) {
                tasks.remove(t);
                task = t;
                break;
            }
        }

        this.removeTask(task);
    }

    public void removeTask(String name) {
        Task task = new Task();

        for (Task t : tasks) {
            if (t.getName().equals(name)) {
                tasks.remove(t);
                task = t;
                break;
            }
        }

        this.removeTask(task);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    @Override
    public String toString() {
        if (tasks.isEmpty()) {
            return "\tNo tasks found";
        }
        System.out.println("\tTasks:");
        for (Task task : tasks) {
            System.out.println("\t\t" + task);
        }
        return "";
    }
}
