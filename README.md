# user_service

Java backend pet-project, который я развиваю в рамках собственного обучения и Java backend bootcamp.

Цель проекта — последовательно пройти путь от базового Spring Boot-приложения к более полноценному backend-сервису и на практике разбирать архитектуру приложения, работу с данными и API.

## What is implemented

- REST API for user management
- Layered architecture: controller / service / repository
- PostgreSQL
- JPA / Hibernate
- Liquibase database migrations
- DTO layer and MapStruct mapping
- Bean Validation
- Global exception handling
- Request user context

## Tech stack

- Java 21
- Spring Boot 3
- Spring Web
- Spring Data JPA
- PostgreSQL
- Liquibase
- MapStruct
- Gradle

## Current architecture

Client  
↓  
REST Controller  
↓  
Service Layer  
↓  
Repository  
↓  
PostgreSQL

The application uses DTOs for API contracts and a separate persistence model for database entities.

## Why this project

Я использую этот проект как практическую площадку для системного изучения Java backend-разработки.

Мне важно не просто собрать CRUD, а последовательно разбираться:

- как разделять ответственность между слоями;
- как моделировать данные;
- как работать со схемой БД и миграциями;
- как проектировать API;
- как постепенно усложнять архитектуру без лишних технологий ради технологий.

## Development roadmap

Проект развивается постепенно по мере прохождения Java backend bootcamp.

Планирую дальше изучать и добавлять:

- более сложную бизнес-логику;
- тестирование;
- Kafka;
- Redis;
- межсервисное взаимодействие;
- постепенное разделение системы на несколько сервисов.

Главная цель — не просто добавить технологии, а понять, зачем они нужны и какие архитектурные задачи решают.

> Work in progress — the repository evolves together with my Java backend bootcamp.