# Kaiburr Task 1 - Java Backend and REST API

## 📋 Overview

This project implements a REST API for managing and executing "task" objects. Each task stores a shell command that can be executed, and its output/history is tracked in MongoDB.

## 🛠️ Technologies

- **Java 17**
- **Spring Boot 3.5.6**
- **MongoDB**
- **Docker & Docker Compose**
- **Maven**
- **Postman** (for testing)

## 📁 Project Structure

```
TASKRUNNER/
├── .mvn/
├── Screenshots/
├── src/
│   ├── main/
│   │   ├── java/com/kaiburi/assessment/taskrunner/
│   │   │   ├── controller/
│   │   │   │   └── TaskController.java
│   │   │   ├── model/
│   │   │   │   ├── Task.java
│   │   │   │   └── TaskExecution.java
│   │   │   ├── repository/
│   │   │   │   └── TaskRepository.java
│   │   │   ├── service/
│   │   │   │   ├── CommandValidator.java
│   │   │   │   ├── TaskService.java
│   │   │   │   └── TaskRunnerApplication.java
│   │   │   └── resources/
│   │   │       ├── static/
│   │   │       ├── templates/
│   │   │       └── application.properties
│   │   └── test/
├── docker-compose.yaml
├── Dockerfile
├── HELP.md
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## 🚀 How to Run

### 1. Build the JAR file

```bash
mvn clean package
```

### 2. Start using Docker Compose

```bash
docker compose up --build
```

### 3. Access the Application

The application runs at:
```
http://localhost:8080/api/tasks
```

## 🔌 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/api/tasks` | Get all tasks |
| `GET` | `/api/tasks/{id}` | Get a specific task by ID |
| `PUT` | `/api/tasks` | Create or update a task |
| `DELETE` | `/api/tasks/{id}` | Delete a task |
| `GET` | `/api/tasks/search?name=...` | Search tasks by name |
| `PUT` | `/api/tasks/{id}/executions` | Execute a task command |

## 📝 Example Usage

### Create a Task
```bash
PUT http://localhost:8080/api/tasks
Content-Type: application/json

{
  "id": "1",
  "name": "List Files",
  "owner": "admin",
  "command": "ls -la"
}
```

### Execute a Task
```bash
PUT http://localhost:8080/api/tasks/1/executions
```

### Get All Tasks
```bash
GET http://localhost:8080/api/tasks
```

## 👨‍💻 Author

**Name:** Karthik S  
**Project:** Kaiburr Assessment - Task 1  
**Date:** October 2025

## 📄 License

This project is part of the Kaiburr Assessment.

---

For questions or issues, please contact the author.