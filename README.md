# 🏨 KIET Hostel Management System

## 📌 Project Description
The KIET Hostel Management System is a menu-driven Java application developed using **Java, JDBC, and MySQL**. It helps manage student hostel accommodation records and perform basic database operations efficiently.

## 🚀 Technologies Used
- Java
- JDBC (Java Database Connectivity)
- MySQL
- Maven
- IntelliJ IDEA

## ✨ Features

The application provides the following operations:

1. **Insert Student Records** – Add new hostel student details into the database using PreparedStatement.
2. **Retrieve Student Records** – Display students belonging to a specified hostel whose hostel fee is greater than ₹50,000, sorted in descending order of fees.
3. **Update Hostel Fee** – Update the hostel fee of a student using their Student ID.
4. **Search and Modify Hostel Details** – Search for a student and update their room number.
5. **Aggregate Query and Conditional Deletion** – Calculate total hostel fees using SQL SUM() and delete a student record if their fee is greater than zero.
6. **Exit** – Close the application.

## 🗄️ Database Configuration

**Database Name:** `hostel_db`

**Table Name:** `HostelStudent`

### Table Structure

| Column Name | Data Type | Description |
|---|---|---|
| student_id | INT | Primary Key |
| student_name | VARCHAR(100) | Student Name |
| roll_number | VARCHAR(20) | Roll Number |
| hostel_name | VARCHAR(50) | Hostel Name |
| room_number | VARCHAR(20) | Room Number |
| fee | DOUBLE | Hostel Fee |

### Create Database

```sql
CREATE DATABASE hostel_db;

USE hostel_db;

CREATE TABLE HostelStudent (
    student_id INT PRIMARY KEY,
    student_name VARCHAR(100),
    roll_number VARCHAR(20),
    hostel_name VARCHAR(50),
    room_number VARCHAR(20),
    fee DOUBLE
);
```

## 📂 Project Structure

```text
HostelManagement
│
├── src
│   └── main
│       └── java
│           └── org.example
│               ├── Main.java
│               ├── DBConnection.java
│               ├── Student.java
│               ├── StudentManagement.java
│               └── StudentController.java
│
├── pom.xml
├── .gitignore
└── README.md
```

## ⚙️ How to Run the Project

1. Clone the repository:

```bash
git clone https://github.com/saini2055yash-blip/Hostel-management-System.git
```

2. Open the project in IntelliJ IDEA.

3. Create the MySQL database and `HostelStudent` table using the SQL commands provided above.

4. Configure your MySQL username and password in `DBConnection.java` (or set the required environment variable if configured).

Reload Maven dependencies.

Run Main.java.

🔐 Database Connection

The application uses JDBC to connect Java with MySQL. The MySQL Connector/J dependency is managed through Maven.

Note: Do not upload actual database passwords or sensitive credentials to GitHub.

👩‍💻 Author

Khushi Saini

📄 License

This project is created for academic and educational purposes.
