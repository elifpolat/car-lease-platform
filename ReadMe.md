# Car Lease Platform API

## Overview

The **Car Lease Platform API** is a microservice-based REST API designed to facilitate car leasing operations. It allows brokers and leasing companies to manage customers, vehicles, and calculate leasing rates with ease. Built with modern Java and Spring Boot, this API adheres to microservices principles and offers secure, scalable, and maintainable solutions.

---

## Features

- **Customer Management**:
   - Add, update, retrieve, and delete customer records.
   - Supports basic customer attributes like name, address, email, and phone number.

- **Car Management**:
   - Add, update, retrieve, and delete car records.
   - Manages key car details such as brand, model, version, CO2 emissions, and pricing.

- **Lease Rate Calculation**:
   - Calculates lease rates based on mileage, duration, interest rate, and car price.
   - Supports calculation using car ID to fetch vehicle details dynamically.

- **Authentication & Security**:
   - Secured using JWT-based token authentication.
   - Role-based access control (RBAC) for authorized operations.

- **Interactive Documentation**:
   - Swagger UI integration for exploring and testing the API interactively.

- **Developer-Friendly**:
   - Compliant with the Google Java Style Guide.
   - Fully documented with JavaDoc and OpenAPI specifications.
   - Includes comprehensive unit tests for critical components.

---

## Tech Stack

- **Java**
- **Spring Boot**
- **Database**: PostgreSQL
- **Security**: Spring Security with JWT
- **Documentation**: Swagger/OpenAPI 3
- **Build Tool**: Maven

---

## Getting Started

### Prerequisites

1. **Java**: Ensure Java 17 or later is installed.
2. **Maven**: Required for building and running the project.
3. **PostgreSQL**: Set up a PostgreSQL database with the following credentials:
   - **URL**: `jdbc:postgresql://localhost:5432/car_lease_platform`
   - **Username**: `carlease_user`
   - **Password**: `carlease_pass`

### Setup

1. Clone the repository:

  ```
   git clone https://github.com/elifpolat/car-lease-platform.git
   cd car-lease-platform
   ```
2. Build the Project

  ```
   mvn clean install
```
3. Access API Documentation (Swagger UI)
   Once the application is running, access the Swagger UI to explore the API interactively:

Swagger UI

This provides detailed API documentation, schemas, and testing options.


### API Endpoints

1. Customer Management
 - GET /api/customers: Retrieve a list of all customers.
 - GET /api/customers/{id}: Retrieve a customer by their ID. 
 - POST /api/customers: Add a new customer. 
 - PUT /api/customers/{id}: Update an existing customer. 
 - DELETE /api/customers/{id}: Delete a customer.

2. Car Management
 - GET /api/cars: Retrieve a list of all cars. 
 - GET /api/cars/{id}: Retrieve a car by its ID. 
 - POST /api/cars: Add a new car. 
 - PUT /api/cars/{id}: Update an existing car. 
 - DELETE /api/cars/{id}: Delete a car.
3. Lease Rate Calculation
 - POST /api/lease/calculate: Calculate the lease rate based on parameters like mileage, duration, interest rate, and price.
 - POST /api/lease/calculate-with-car-id: Calculate the lease rate using a car ID to fetch vehicle details.

### Future Enhancements
 - Containerization using Docker for easier deployment.
 - Persistent datastore integration (e.g., PostgreSQL in production environments).
 - Advanced metrics and logging with tools like Prometheus and Grafana.
 - Fixing bugs in SwaggerUI