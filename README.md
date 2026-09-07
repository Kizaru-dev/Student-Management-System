# Student Management System

A Spring Boot web application for managing student records through a clean and responsive interface. This project demonstrates CRUD operations, layered MVC architecture, database integration, and server-side rendering with Thymeleaf.

## Features

- Create new student records
- View all students
- Update student information
- Delete student records
- Search students by name
- Case-insensitive and partial-name search
- Display feedback when no student is found
- Responsive interface using Bootstrap

## Tech Stack

| Layer | Technology |
| --- | --- |
| Backend | Java, Spring Boot, Spring MVC |
| Data Access | Spring Data JPA |
| Frontend | Thymeleaf, HTML, Bootstrap |
| Build Tool | Maven |
| Database | MySQL |

## Architecture

The project follows a layered architecture:

```text
Browser → Controller → Service → Repository → Database
