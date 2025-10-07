# task-list
Project with some tasks list 

A simple task management project developed in Java with Spring Boot, demonstrating CRUD (Create, Read, Update, Delete) operations and automated testing.

---

## Features

- Create, update, list, and delete task lists
- Data validation using Jakarta Validation
- DTOs for data transfer
- Unit testing with **JUnit 5** and **Mockito**
- Mapping between entities and DTOs
- Use of **Spring Data JPA** for database persistence (MySQL, H2, etc.)

---

## Technologies used

- Java 17+
- Spring Boot 3+
- Spring Data JPA
- H2 Database / MySQL
- Jakarta Validation
- JUnit 5 + Mockito
- Maven / Gradle

---

## Project Structure

src/
├── main/
│ ├── java/com/task/list
│ │ ├── controller
│ │ ├── service
│ │ ├── repository
│ │ └── dto
│ └── resources
│ └── application.properties
└── test/
└── java/com/task/list
└── Testes unitários e de integração

## How to run the project

1. Clone the repository:
```bash
git clone https://github.com/seuusuario/tasklist.git
cd tasklist

mvn spring-boot:run

API endpoints

GET /tasklists → Lists all task lists

POST /tasklists → Creates a new task list
Example JSON request:

 {
  “name”: “Shopping list,”
  “description”: “Items to buy at the supermarket”
}

PUT /tasklists/{id} → Updates an existing list
Example JSON request:

{
  “name”: “Updated task list,”
  “description”: “Updated description”
}

Tests

To run the automated tests:

mvn test

All tests passed, ensuring the integrity of CRUD operations.

Future improvements

Authentication and authorization with Spring Security

Integration with front-end in Angular or React

Filters and advanced task search

Cloud deployment (Heroku, AWS)


