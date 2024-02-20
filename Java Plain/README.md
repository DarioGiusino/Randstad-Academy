# BookOnline
This project, developed in a team of two people, represents a Java application for an online book store. The main goal is to provide users with the ability to register, browse the book catalog, make purchases, and share reviews.

Main Features:
User Management: Users can register, log in to the library, and view the book catalog.
Book Catalog: Books are managed in a catalog with information such as title, author, genre, and price.
Reviews: Users can write reviews on purchased books, rating them from 1 to 5 stars.
Book Purchase: Users can purchase books and view purchased books.
Recommendations: A list of recommended books is provided based on the user's preferred genres and positive reviews.
Popular Books: A list of the most popular books is shown based on reviews.

# BookShop
This code represents a simulator of an online book store developed in Java. The Shop class manages user interactions, allowing them to operate as both "guests" and "admins". "Guest" users can purchase books, view their list, and access as "admins" via a password. "Admin" users have access to advanced features such as adding, removing, and modifying books in the catalog.

Key Features:
User Roles: Manages specific actions for "guest" and "admin" users.
Interactive Menus: Provides a text-based interface for the user, allowing them to choose actions such as purchasing, viewing books, and managing the catalog.
Operation Management: Purchase, view, and book management functions are implemented modularly.

Use of Static Variables:
Uses static variables to manage the application state, including the list of books, user status, and menus.
This implementation provides a basic interface for users to interact with a simulated book store. The main functions are modular and divided into dedicated methods, facilitating code extension and maintenance.

# CarManager
The code presents management of a car database through the user interface and manipulation of Car objects. It was developed using Java, interacting with a MySQL database.

Main Classes:
CarManager:
This class manages operations on cars, such as adding, modifying, deleting, and displaying.
It is also possible to search for a car by license plate.
It uses methods to synchronize data with the database and manage interaction with it.
The Utilities class is used for user input.

ConnectionUtils:
Manages the connection to the database and operations such as obtaining ResultSet, displaying results, etc.
Uses JDBC connection to connect to the MySQL database.

Utilities:
Utility class that provides a method for user input.

Highlights:
CRUD Operations: The CarManager class allows performing CRUD operations on the car database.
Database Interaction: The ConnectionUtils class manages the connection to the database and operations on it, such as executing queries and retrieving data.
Secure User Input: The Utilities class provides a method for obtaining user input safely, validating and converting types.
The code is structured to separate responsibilities, facilitating management and maintenance. Exception handling and comments are present to guide code understanding.

Additionally, the code handles date formatting for data insertion and updating in the database.

# Final Exercise in Plain Java
Final exercise in plain Java, as described in the ReadMe inside.

# Restaurant Manager
The repository offers a reservation management solution for tables in a restaurant. The PrenotazioneServiceImpl class provides methods to reserve a table, cancel a reservation, and view available tables.

Main Features
Book a Table: Users can book a table by specifying the number of people, date, and desired time.
Cancel Reservation: Allows canceling an existing reservation by selecting the corresponding row.
View Available Tables: Provides a list of currently available tables for booking.

Code Structure
The code is structured as a service, aiming to efficiently manage user interactions through an implementation of intuitive methods.

Database: Use of JDBC for interaction with a MySQL database.
User Management: User interaction via console input.
The code uses object-oriented programming patterns, access to relational databases, and exception handling to ensure reliable operation.

# ShopJDBC
The repository provides a shop management application that allows users to view the catalog, manage the shopping cart, and access administrative functionalities through an "ADMIN DASHBOARD". This structure adopts the concepts of DAO (Data Access Object) and uses DTO (Data Transfer Object) classes to separate business logic from data access.

Implemented Classes
ProductDAO.java: This class handles access to store product data. It provides methods for basic operations, such as insertion, modification, deletion, and retrieval of products from the database.

ClienteDAO.java: Similar to ProductDAO, this class handles access to customer data, providing similar functionality for interaction with the customer table.

OrdineDAO.java: Manages access to order data, providing the necessary methods to handle order information in the database.

DTO Classes (e.g., ProductDTO, ClienteDTO, OrdineDTO): These classes contain attributes and methods for transferring data between the application logic and the database. Each DTO class represents a database table and defines the data structures needed for data transfer.

Application Flow
Guests:
They can view the product catalog and add items to the shopping cart.
They can access the "ADMIN DASHBOARD" by entering a specific password.

Admins:
They have access to the "ADMIN DASHBOARD" to manage products, customers, and orders.
Use of DAO and DTO

The use of DAO allows separating business logic from data access, improving code structure, and making operations performed on the database clearer. DTOs act as interfaces between data access classes and application logic, ensuring efficient and consistent data transfer.

The DAO-DTO structure adopted promotes code modularity, simplifying system maintenance and extension over time.

# WeatherStation
The provided code represents a simplified weather monitoring application that simulates a weather station. It uses the Observer pattern to notify various observers (such as operators and vehicles) when there are updates regarding weather conditions in different regions.

Code Description:
MeteoInfo: Represents meteorological information related to temperature, wind speed, last update date, and associated region.

Operator and Vehicle: Implement the Observer interface to receive meteorological updates from the weather station. Operators show only temperature information, while vehicles show the last weather update date.

Weather Station: Maintains a list of observers and updates all registered observers when it receives new meteorological information. Each interested observer receives the data and updates relevant information.

Region: Enumeration of supported regions for observing weather conditions.

Usage:
The Main class initializes the weather station and various observers (operators and vehicles) to monitor weather conditions.
Adds observers to the weather station.
The weather station receives meteorological information via the updateWeather method and subsequently notifies registered observers.
Design Pattern:
The code uses the Observer design pattern, allowing the weather station to automatically notify interested observers when there are meteorological updates.

This example can be used as a basis for understanding how the Observer pattern works and how to implement asynchronous communication between objects, useful in notification and distributed update contexts.

# TestJDBC
The provided code represents a Java application that interacts with a MySQL database called negozio_db, performing query operations (SELECT) and closing the connection. Additionally, it contains an example of using the ConnectionUtils and Main classes to handle database connection and display query results.

Structure and Functionality:
Main: Presents an example of using the ConnectionUtils class, executing an SQL query to retrieve and display the product catalog from the negozio_db database.

ConnectionUtils: Contains methods to handle the connection to the MySQL database (negozio_db), execute queries, obtain and print the results obtained.

Functional Description:
The Main method initializes an instance of ConnectionUtils passing credentials and the database name. Subsequently, it executes an

 SQL query that retrieves data from the "product" table and prints it to the console.
The ConnectionUtils method handles the connection to the database, receives and prints the results of the executed queries.

Usage:
The shown example illustrates how to establish a connection to a MySQL database, execute queries, and obtain results. By replacing the queries inside the main method of the Main class, different queries can be executed and results displayed.

Notes:
The example mainly focuses on executing selection queries (SELECT) and displaying the returned results.

This example can be used as a guide for interacting with a MySQL database from a Java application, providing a simple and practical introduction to accessing and using data stored in a relational database.
