Event Management app PostgreSQL Event Management System using:

✅ Core Java (OOP, JDBC, Exception Handling, Multithreading)

✅ PostgreSQL Database

✅ Maven Project Structure

📂Project Structure 
EventManagementSystem/
│
├── DatabaseConnection.java
├── Event.java
├── User.java
├── EventService.java
├── RegistrationThread.java
└── EventApp.java

💾 PostgreSQL Database Setup

CREATE TABLE events (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    date DATE,
    location VARCHAR(100)
);

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100)
);

CREATE TABLE registrations (
    id SERIAL PRIMARY KEY,
    event_id INT REFERENCES events(id),
    user_id INT REFERENCES users(id),
    registered_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

Configuration Edit the PostgreSQL credentials in Databaseconnection.java:
String URL = "jdbc:postgresql://localhost:5432/eventdb";
String USER = "postgres";
String PASSWORD = "your_password";

Set up PostgreSQL and create the required tables.

Open the project in Eclipse, or any IDE with Maven support.

Run Main.java to start the app.

Use the console menu to:
<img width="256" height="144" alt="2025-07-10 (2)" src="https://github.com/user-attachments/assets/894eb21a-0f29-4281-97bd-08a97d850a6b" />

🎯 Features:

1. Create events


2. Register users


3. Assign users to events


4. View all events


5. View participants of an event


6. Exit

Dependencies(in pom.xml)

💡 Author 

Made with by
👩‍💼Riddhi Bhojane, 👩‍💼Shruti Nikam, 👩‍💼Snehal Bandgar.





