🍉 Fruits Ecommerce – Graduation Project


🎓 Project Overview

Fruits Ecommerce is an online marketplace backend project built for a mentorship program graduation.
It focuses on providing a full-featured backend for an e-commerce platform selling fruits, including secure authentication, email notifications, database migrations, and RESTful APIs.

⚡ Features

🔐 Spring Security: User authentication & authorization (JWT ready)

🛒 REST APIs: CRUD operations for Products, Orders, Users

🗃️ MySQL: Relational database with migration scripts

📧 JavaMail: Sending email notifications (order confirmations, password reset)

🧪 Mockito: Unit and integration testing

🔄 MapStruct: Entity-DTO mapping

📜 Database Migration: Version-controlled database changes

🖥️ Swagger & OpenAPI: API documentation and testing

🛠️ Tech Stack
Technology	Version / Notes
Java	17
Spring Boot	3.2.0
Spring Security	6.x
REST APIs	Spring Web + OpenAPI
Database	MySQL 8.0
Testing	Mockito + JUnit
Mapping	MapStruct
API Docs	Swagger / OpenAPI
Email Service	JavaMail
🚀 Getting Started
Prerequisites

Java 17 or above

Maven 4.x

MySQL 8.x

Setup

Clone the repository:

git clone https://github.com/<your-username>/fruits-ecommerce.git
cd fruits-ecommerce


Configure database in application.yml:

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/fruits_ecommerce
    username: root
    password: your_password


Run the application:

mvn spring-boot:run


Access Swagger UI:

http://localhost:8080/swagger-ui/index.html

📧 Email Configuration

Configure mail properties in application.yml:

spring:
  mail:
    host: smtp.gmail.com
    port: 587
    username: your-email@gmail.com
    password: your-email-password
    properties:
      mail.smtp.auth: true
      mail.smtp.starttls.enable: true

🧪 Testing

Run unit tests with:

mvn test

📌 API Documentation

All REST APIs are documented via Swagger/OpenAPI

Endpoint example: GET /api/products – returns all products

🛠️ Future Improvements

Add cart & checkout microservice

Integrate payment gateway

Implement role-based access control for admin & users

Add frontend integration (React / Angular)
