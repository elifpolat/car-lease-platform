# Car Lease Platform API

This is a RESTful API for managing customers and cars for a car leasing platform. It provides endpoints for operations such as creating, retrieving, updating, and deleting customers and cars. The API is secured with JWT-based authentication.

## Table of Contents
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Requirements](#requirements)
- [Setup and Installation](#setup-and-installation)
- [Running the Application](#running-the-application)
- [API Documentation](#api-documentation)
- [Testing the API](#testing-the-api)
- [Contributing](#contributing)
- [License](#license)

## Features
- Manage customers (CRUD operations).
- Manage cars (CRUD operations).
- JWT-based authentication for secure access.
- OpenAPI (Swagger) documentation.

## Tech Stack
- **Java**: Version 17 or above
- **Spring Boot**: 3.4.0
- **Database**: PostgreSQL
- **Build Tool**: Maven

## Requirements
- **Java Development Kit (JDK)**: Version 17 or above.
- **Maven**: Version 3.6 or above.
- **PostgreSQL**: Ensure you have a running PostgreSQL instance.
- **Git**: To clone the repository.

## Setup and Installation
1. Clone the repository:
   ```
   git clone https://github.com/elifpolat/car-lease-platform.git
   cd car-lease-platform


2. Build the Docker image:
```
docker build -t car-lease-platform .
```
Run the Docker container:

```
docker run -p 8080:8080 --name car-lease-platform car-lease-platform
```

3. Running the Application

    The application runs on http://localhost:8080 by default.


## Documentation
1. API Documentation
API documentation is available via Swagger at http://localhost:8080/swagger-ui.html.
Alternatively, you can view the OpenAPI specification in the src/main/openapi/carleaseapi.yaml file.