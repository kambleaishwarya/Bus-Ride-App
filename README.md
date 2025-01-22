# Bus-Ride-App
Project Title
Vehicle Management API

# Description
This project is a RESTful API for managing vehicle data. It provides endpoints to perform CRUD operations on vehicles, such as retrieving all vehicles, creating new ones, updating existing ones, and deleting vehicles.

# Technologies Used
Java (JDK 11)
Spring Boot
Spring Data JPA
MySQL
Hibernate
Maven

# Features
Retrieve all vehicles
Retrieve a vehicle by its number
Create a new vehicle
Update vehicle details
Delete a vehicle

# Endpoints
HTTP Method	Endpoint   	    Description
GET	/api/vehicles	        Retrieve all vehicles
GET	/api/{number}	        Retrieve a vehicle by its number
POST	/api/vehicles	    Create a new vehicle
PUT	/api/vehicles/{id}	    Update a vehicle by ID
DELETE	/api/vehicles/{id}	Delete a vehicle by ID

# Example Request and Response
POST /api/vehicles
Request Body:

json

{
    "name": "Mahindra Thar",
    "number": "MH34",
    "seats": 7,
    "type": "SUV"
}
Response:

json

{
    "id": 1,
    "name": "Mahindra Thar",
    "number": "MH34",
    "seats": 7,
    "type": "SUV"
}
GET /api/vehicles
Response:
json

[
    {
        "id": 1,
        "name": "Mahindra Thar",
        "number": "MH34",
        "seats": 7,
        "type": "SUV"
    }
]

# Database Schema

CREATE TABLE vehicles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    number VARCHAR(255) UNIQUE NOT NULL,
    seats INT NOT NULL,
    type VARCHAR(255) NOT NULL
);

# Setup Instructions
Clone the Repository:

git clone git clone https://github.com/kambleaishwarya/Bus-Ride-App.git
cd Bus-Ride-App
Configure the Application Properties: Update src/main/resources/application.properties with your database details:

# application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/vehicle_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update


# Build the Project:
mvn clean install

#Run the Application:
mvn spring-boot:run

# Future Enhancements
Implement user authentication.
Add filtering and sorting capabilities.

# Contributing
Contributions are welcome! Please fork this repository and create a pull request with your changes.

# Contact
For any inquiries or feedback, contact [aishwarya.kamble@pinnacle.in].

