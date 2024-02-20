# FinalTest-Java

The application represents a management system for a toy store, developed in the Java language. It consists of several classes and utilities to manage an inventory of toys, sales, and interactions with customers.

The main features include:

Entity Classes: The "Customer" and "Toy" classes represent the store's customers and the toys available for sale, respectively. Each entity is characterized by attributes and methods to get and set specific information.

"Inventory" Class: Manages the list of toys available in the store, providing functionality to view the inventory and add new toys.

"Menu" Class: User interface for the store, allowing both users (such as customers) and administrators to interact with the system. Users can make purchases, while administrators can manage the inventory, view sales, and add new toys.

Utility Classes: The "Utilities" class offers user input functionality, supporting various input types such as Integer, Double, String, Float, Long.

"Sale" Class and abstract "SalesRegister": Handle the recording of toy sales by customers and the display of sales themselves.

The application, developed as part of a training program at Randstad Academy, demonstrates the use of fundamental Java programming concepts to manage a toy store management system. The classes and interfaces are designed to provide a solid conceptual and practical foundation in inventory management, sales, and customer interactions.

# FinalTest-Spring

The application in question is a Spring Boot project that manages an order management system, customers, and products through a series of REST endpoints.

Project Structure:

The project is divided into packages that include classes for entities, repositories, services, and controllers.
Entities include: Customer, Order, and Product, each with their own properties and relationships defined through JPA annotations.
Repositories extend JpaRepository and allow interaction with the database for CRUD operations related to entities.
Services provide business logic and manage operations on entities.
Controllers provide REST access points for CRUD operations on entities.
Features:

Customer: The endpoints allow retrieving all customers, finding a customer by ID, saving a new customer, updating, or deleting a customer.
Order: Offers similar operations to customers, allowing to manage orders in terms of retrieval, creation, updating, and deletion.
Product: Manages products through CRUD operations, allowing access, creation, updating, or deletion of products.
Database:

An in-memory H2 database is configured (spring.datasource.url=jdbc:h2:mem:testdb), which is created and destroyed with the application.
Configuration properties for the datasource, driver, authentication, and ddl-auto for Hibernate are specified in the application.properties file.
The application provides basic functionality for managing an order system, allowing users to interact with the database through REST APIs.
