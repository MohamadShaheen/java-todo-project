# Task Manager

## 📌 Overview
Task Manager is a simple command-line Java application for managing a list of tasks. It allows users to add, remove, list, and mark tasks as completed while ensuring that tasks persist across program runs using JSON storage.

## ⚙️ Features
- 📝 **Add Tasks** – Create new tasks with a unique ID.
- ❌ **Remove Tasks** – Delete tasks by their ID, making the ID available for future tasks.
- ✅ **Mark Tasks as Completed** – Update a task’s status to completed.
- 📜 **List All Tasks** – Display all tasks with their completion status.
- 💾 **Persistent Storage** – Tasks are stored in a JSON file using `ObjectMapper` in a key-value format (`taskId → Task`).

## 🛠️ Technologies Used
- **Java** – Core logic implementation.
- **Jackson ObjectMapper** – JSON serialization and deserialization.
- **File I/O** – Read/write operations to store tasks.

## 🚀 How to Run
1. Clone the repository:
   ```shell
   git clone https://github.com/MohamadShaheen/task-manager.git
   cd task-manager
   ```
2. Compile and run the project:
    ```shell
    javac src/Main.java
    java src.Main
    ```

## 📜 Example JSON Storage Format
```json
{
  "1": {"id": 1, "name": "Buy groceries", "completed": false},
  "2": {"id": 2, "name": "Finish project", "completed": true}
}
```