package org.example;

public class Student {

    int student_id;
    String student_name;
    String roll_number;
    String hostel_name;
    String room_number;
    double fee;

    public Student(int id, String name, String roll,
                   String hostel, String room, double fee) {

        this.student_id = id;
        this.student_name = name;
        this.roll_number = roll;
        this.hostel_name = hostel;
        this.room_number = room;
        this.fee = fee;
    }

    public void display() {

        System.out.println("Student ID: " + student_id);
        System.out.println("Student Name: " + student_name);
        System.out.println("Roll Number: " + roll_number);
        System.out.println("Hostel Name: " + hostel_name);
        System.out.println("Room Number: " + room_number);
        System.out.println("Hostel Fee: " + fee);
        System.out.println("---------------------------");
    }
}