package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean running = true;
        var taskManager = new TaskManager();
        var scanner = new Scanner(System.in);

        while (running) {
            System.out.println("""
                    [1]: Add Task.\

                    [2]: Remove Task.\

                    [3]: List Tasks.\

                    [4]: Exit.""");
            int operation = scanner.nextInt();

            switch (operation) {
                case 1:
                    System.out.print("Enter task ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter task name: ");
                    String name = scanner.next();
                    System.out.print("Task completed? [y/n]: ");
                    boolean completed;
                    completed = scanner.next().equals("y");
                    var task = new Task(id, name, completed);
                    taskManager.addTask(task);
                    break;
                case 2:
                    System.out.println("""
                            \t1. Remove by ID.\
                                                        
                            \t2. Remove by name.""");
                    System.out.print("\t");
                    int removeFactor = scanner.nextInt();
                    switch (removeFactor) {
                        case 1:
                            System.out.print("\tEnter task ID: ");
                            id = scanner.nextInt();
                            taskManager.removeTask(id);
                            break;
                        case 2:
                            System.out.print("\tEnter task name: ");
                            name = scanner.next();
                            taskManager.removeTask(name);
                            break;
                        default:
                            System.out.println("\tInvalid input.");
                    }
                    break;
                case 3:
                    System.out.println(taskManager);
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid input.");
            }
        }
    }
}
