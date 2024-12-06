# Todo List Application

## Overview

This project is a simple Todo List application developed as part of a mentorship program. The goal is to help a group of friends who are transitioning to a new career in software development and have no prior programming experience. The application allows users to create, update, view, and delete tasks.

## Technologies Used

- **Java**: The primary programming language used for the application.
- **Spring Boot**: A framework that simplifies the development of Java applications.
- **Maven**: A build automation tool used for managing project dependencies.
- **PostgreSQL**: The relational database management system used to store task data.
- **Lombok**: A library that helps reduce boilerplate code by generating getters, setters, and other methods.

## Project Structure

- `src/main/java/br/com/agls/todo_list/api/controller`: Contains the REST controllers for handling HTTP requests.
- `src/main/java/br/com/agls/todo_list/domain/entity`: Contains the entity classes that represent the database tables.
- `src/main/java/br/com/agls/todo_list/domain/service`: Contains the service classes that contain the business logic.
- `src/main/resources`: Contains the application configuration files.

## Getting Started

### Prerequisites

- Java 21 or higher
- Maven 3.6 or higher
- PostgreSQL 13 or higher

### Setup

1. **Clone the repository**:
    ```sh
    git clone https://github.com/andreleao1/todo-list.git
    cd todo-list
    ```

2. **Configure the database**:
    - Create a PostgreSQL database named `todo-list`.
    - Update the database connection settings in `src/main/resources/application.properties`:
        ```ini
        spring.datasource.url=jdbc:postgresql://localhost:5432/todo-list
        spring.datasource.username=your_username
        spring.datasource.password=your_password
        ```

3. **Build the project**:
    ```sh
    mvn clean install
    ```

4. **Run the application**:
    ```sh
    mvn spring-boot:run
    ```

### API Endpoints

- **Create a Task**: `POST /tasks`
- **Update a Task**: `PUT /tasks/{id}`
- **Get a Task by ID**: `GET /tasks/{id}`
- **Get All Tasks**: `GET /tasks`
- **Delete a Task**: `DELETE /tasks/{id}`
