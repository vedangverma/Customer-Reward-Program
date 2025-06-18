# Customer Rewards Program - Spring Boot REST API

This project implements a RESTful API to calculate reward points for customers based on their monthly purchase history. It is developed using Spring Boot and includes mock data, unit tests, integration tests, and exception handling.

# Business Logic

- Customers earn:
  - (2 point) for every dollar spent **over $100**
  - **1 point** for every dollar spent **between $50 and $100**
  - No points for purchases under $50

- Example:
  - A purchase of **$120** yields:
    - 2 * (120 - 100) = 40 points
    - 1 * (100 - 50) = 50 points
    - Total = **90 points**

---

## How to Run the Project

### Prerequisites:
- Java 17+
- Maven
- IntelliJ IDEA or any Java IDE

### Build & Run:
```bash
mvn clean install
mvn spring-boot:run

The application runs on: http://localhost:8080

Features
Monthly and total reward points per customer

RESTful API built using Spring Boot

In-memory data (no DB required)

Unit & integration tests included

Exception handling & input validation

JavaDocs at class/method levels

Follows Java coding standards
