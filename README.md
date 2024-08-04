# To-Do List Application - Backend

Welcome to the backend of the **To-Do List Application**! This part of the project is built with Java and Spring Boot, providing a robust API for managing tasks and users.

## Table of Contents

- [Features](#features)
- [Technologies](#technologies)
- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)

## Features

- **User Management**: Create, read, update, and delete users.
- **Task Management**: Create, read, update, and delete tasks.
- **Data Persistence**: Persistent storage using PostgreSQL.
- **Error Handling**: Detailed error messages and validation.
- **Transactional Support**: Ensures database consistency and integrity.

## Technologies

- **Java**: Programming language.
- **Spring Boot**: Framework for building the backend.
- **Spring Data JPA**: ORM for interacting with the PostgreSQL database.
- **PostgreSQL**: Database for storing user and task data.
- **Maven**: Build tool for managing dependencies and project structure.
- **Docker**: Containerization for consistent environments.

## Installation

### Prerequisites

- Java 17 or higher
- PostgreSQL database
- Maven (for building the project)

### Clone the Repository

```bash
git clone https://github.com/AjayWankhade/to-do-with-java.git
cd to-do-with-java/backend
```

### Configure the Database

1. **Create a PostgreSQL Database**:
   - Create a new database named `todo_db` or another name of your choice.

2. **Update Application Properties**:
   - Open `src/main/resources/application.properties` and configure the database connection settings:
     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/todo_db
     spring.datasource.username=your_db_username
     spring.datasource.password=your_db_password
     ```

### Build and Run the Application

1. **Build the Project**:
   ```bash
   mvn clean install
   ```

2. **Run the Application**:
   ```bash
   mvn spring-boot:run
   ```

The backend server will start on `http://localhost:8080`.

## Usage

The backend provides a RESTful API that can be accessed by the frontend application or any HTTP client. The API endpoints allow you to manage users and tasks effectively.

## API Endpoints

### Users

- **Create a User**
  - `POST /api/users`
  - Request body: 
    ```json
    {
      "firstName": "John",
      "lastName": "Doe",
      "userName": "johndoe",
      "password": "password123"
    }
    ```

- **Get All Users**
  - `GET /api/users`

- **Get User by ID**
  - `GET /api/users/{id}`

- **Update a User**
  - `PUT /api/users/{id}`
  - Request body: 
    ```json
    {
      "firstName": "John",
      "lastName": "Doe",
      "userName": "johndoe",
      "password": "newpassword"
    }
    ```

- **Delete a User**
  - `DELETE /api/users/{id}`

### Tasks

- **Create a Task**
  - `POST /api/tasks`
  - Request body: 
    ```json
    {
      "title": "Task Title",
      "description": "Task Description",
      "status": "To-Do"
    }
    ```

- **Get All Tasks**
  - `GET /api/tasks`

- **Get Task by ID**
  - `GET /api/tasks/{id}`

- **Update a Task**
  - `PUT /api/tasks/{id}`
  - Request body: 
    ```json
    {
      "title": "Updated Title",
      "description": "Updated Description",
      "status": "In Progress"
    }
    ```

- **Delete a Task**
  - `DELETE /api/tasks/{id}`
