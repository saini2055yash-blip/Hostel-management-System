package org.example;

import java.util.Scanner;

public class StudentController {

    StudentManagement sm = new StudentManagement();
    Scanner sc = new Scanner(System.in);

    public void menu() {

        int choice;

        do {

            System.out.println("\n===== KIET HOSTEL MANAGEMENT SYSTEM =====");

            System.out.println("1. Insert Student Record");
            System.out.println("2. Retrieve Students");
            System.out.println("3. Update Hostel Fee");
            System.out.println("4. Search and Update Room");
            System.out.println("5. Display Total Fee and Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sm.insertStudent();
                    break;

                case 2:
                    sm.retrieveStudents();
                    break;

                case 3:
                    sm.updateFee();
                    break;

                case 4:
                    sm.updateRoom();
                    break;

                case 5:
                    sm.deleteStudent();
                    break;

                case 6:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);
    }
}