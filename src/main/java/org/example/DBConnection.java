package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    // Method to connect Java with MySQL
    public static Connection getConnection() {

        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hostel_db",
                    "root",
                    "root"
            );

        } catch (Exception e) {
            System.out.println("Database Connection Failed!");
            e.printStackTrace();
        }

        return con;
    }

    // Main method to test database connection
    public static void main(String[] args) {

        Connection con = getConnection();

        if (con != null) {

            System.out.println("DATABASE CONNECTED SUCCESSFULLY!");

            try {
                con.close();
                System.out.println("Connection Closed.");
            } catch (Exception e) {
                System.out.println(e);
            }

        } else {

            System.out.println("DATABASE NOT CONNECTED!");

        }
    }
}
