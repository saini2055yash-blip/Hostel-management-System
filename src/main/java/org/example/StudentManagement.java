package org.example;

import java.sql.*;
import java.util.Scanner;

public class StudentManagement {

    Connection con = DBConnection.getConnection();
    Scanner sc = new Scanner(System.in);

    // (a) INSERT STUDENT RECORD
    public void insertStudent() {

        try {
            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Roll Number: ");
            String roll = sc.nextLine();

            System.out.print("Enter Hostel Name: ");
            String hostel = sc.nextLine();

            System.out.print("Enter Room Number: ");
            String room = sc.nextLine();

            System.out.print("Enter Hostel Fee: ");
            double fee = sc.nextDouble();

            String query = "INSERT INTO HostelStudent VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, roll);
            ps.setString(4, hostel);
            ps.setString(5, room);
            ps.setDouble(6, fee);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Inserted Successfully!");
            }

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Duplicate Student ID! Record already exists.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    // (b) CONDITIONAL RETRIEVAL AND SORTING
    public void retrieveStudents() {

        try {
            sc.nextLine();

            System.out.print("Enter Hostel Name: ");
            String hostel = sc.nextLine();

            String query = "SELECT * FROM HostelStudent " +
                    "WHERE hostel_name = ? AND fee > 50000 " +
                    "ORDER BY fee DESC";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, hostel);

            ResultSet rs = ps.executeQuery();

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println("\nStudent ID: " + rs.getInt("student_id"));
                System.out.println("Name: " + rs.getString("student_name"));
                System.out.println("Roll: " + rs.getString("roll_number"));
                System.out.println("Hostel: " + rs.getString("hostel_name"));
                System.out.println("Room: " + rs.getString("room_number"));
                System.out.println("Fee: " + rs.getDouble("fee"));
            }

            if (!found) {
                System.out.println("No matching students found.");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    // (c) UPDATE HOSTEL FEE
    public void updateFee() {

        try {
            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();

            System.out.print("Enter New Hostel Fee: ");
            double fee = sc.nextDouble();

            String query = "UPDATE HostelStudent SET fee = ? WHERE student_id = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setDouble(1, fee);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Hostel Fee Updated Successfully!");
            } else {
                System.out.println("Student Record Does Not Exist!");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    // (d) SEARCH AND MODIFY HOSTEL DETAILS
    public void updateRoom() {

        try {
            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            String search = "SELECT * FROM HostelStudent WHERE student_id = ?";

            PreparedStatement ps = con.prepareStatement(search);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\nStudent Found!");

                System.out.println("Student Name: " + rs.getString("student_name"));
                System.out.println("Old Room Number: " + rs.getString("room_number"));

                System.out.print("Enter New Room Number: ");
                String room = sc.nextLine();

                String update = "UPDATE HostelStudent SET room_number = ? WHERE student_id = ?";

                PreparedStatement ps2 = con.prepareStatement(update);

                ps2.setString(1, room);
                ps2.setInt(2, id);

                ps2.executeUpdate();

                System.out.println("\nUpdated Student Details:");

                String display = "SELECT * FROM HostelStudent WHERE student_id = ?";

                PreparedStatement ps3 = con.prepareStatement(display);
                ps3.setInt(1, id);

                ResultSet rs2 = ps3.executeQuery();

                if (rs2.next()) {
                    Student s = new Student(
                            rs2.getInt("student_id"),
                            rs2.getString("student_name"),
                            rs2.getString("roll_number"),
                            rs2.getString("hostel_name"),
                            rs2.getString("room_number"),
                            rs2.getDouble("fee")
                    );

                    s.display();
                }

            } else {
                System.out.println("Student Record Does Not Exist!");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    // (e) AGGREGATE QUERY AND CONDITIONAL DELETION
    public void deleteStudent() {

        try {

            // Display total fee
            String sumQuery = "SELECT SUM(fee) AS total FROM HostelStudent";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sumQuery);

            if (rs.next()) {
                System.out.println("Total Hostel Fee Collected: " +
                        rs.getDouble("total"));
            }

            // Delete student
            System.out.print("Enter Student ID to Delete: ");
            int id = sc.nextInt();

            String query = "DELETE FROM HostelStudent " +
                    "WHERE student_id = ? AND fee > 0";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Deleted Successfully!");
            } else {
                System.out.println("Student Not Found or Fee Not Fully Paid!");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}