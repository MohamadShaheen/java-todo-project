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
                    
                    [4]: Mark Task as Completed.\

                    [5]: Exit.""");
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
                    System.out.print("\tEnter task ID: ");
                    id = scanner.nextInt();
                    taskManager.removeTask(id);
                    break;
                case 3:
                    System.out.println(taskManager);
                    break;
                case 4:
                    System.out.println("\tEnter task ID: ");
                    System.out.print("\t");
                    id = scanner.nextInt();
                    taskManager.markTaskAsCompleted(id);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid input.");
            }
        }
    }
}
