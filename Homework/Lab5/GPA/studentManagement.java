package Homework.Lab5.GPA;

import java.util.ArrayList;
import java.util.Scanner;

public class studentManagement {
    private static ArrayList<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        studentManagement studentManagement = new studentManagement();

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("[A] Add new student");
            System.out.println("[P] Print all students");
            System.out.println("[S] Search student");
            System.out.println("[U] Update student");
            System.out.println("[D] Delete student");
            System.out.println("[Q] Quit");
            System.out.print("Enter your option: ");

            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "A":
                    studentManagement.addNewStudent(scanner);
                    break;
                case "P":
                    studentManagement.printAllStudents();
                    break;
                case "S":
                    studentManagement.searchStudent(scanner);
                    break;
                case "U":
                    studentManagement.updateStudent(scanner);
                    break;
                case "D":
                    studentManagement.deleteStudent(scanner);
                    break;
                case "Q":
                    System.out.println("Exiting the program...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
//Ananthichai saehui 6530613030 DE.
    public void addNewStudent(Scanner scanner) {
        System.out.println("------------------------------------------");
        System.out.println("+ Add new student. +");
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter GPA: ");
        double gpa = scanner.nextDouble();
        scanner.nextLine();

        Student student = new Student(studentId, studentName, gpa);
        studentList.add(student);
        System.out.println("Add 1 student successfully: ");
        student.printStudentInfo();
        System.out.println("------------------------------------------");
    }

    public void printAllStudents() {
        System.out.println("------------------------------------------");
        for (Student student : studentList) {
            student.printStudentInfo();
        }
        System.out.println("------------------------------------------");
    }

    public void searchStudent(Scanner scanner) {
        System.out.println("------------------------------------------");
        System.out.print("Enter student ID to search: ");
        String searchId = scanner.nextLine();
        int count = 0;
        for (Student student : studentList) {
            if (student.getStudentId().contains(searchId)) {
                student.printStudentInfo();
                count++;
            }
        }
        System.out.println("Found " + count + " student.");
        System.out.println("------------------------------------------");
    }

    public void updateStudent(Scanner scanner) {
        System.out.println("------------------------------------------");
        System.out.print("Enter student ID to update: ");
        String studentId = scanner.nextLine();
        boolean found = false;
    
        for (Student student : studentList) {
            if (student.getStudentId().equals(studentId)) {
                System.out.println("Found student with ID: " + studentId);
                System.out.print("Enter new GPA: ");
                double newGPA = scanner.nextDouble();
                scanner.nextLine();
    
                student.setGpa(newGPA);
                System.out.println("Student GPA updated successfully.");
                found = true;
                System.out.println("------------------------------------------");
                break;
            }
        }
    
        if (!found) {
            System.out.println("Student not found with ID: " + studentId);
        }
    }
    
    public void deleteStudent(Scanner scanner) {
        System.out.println("------------------------------------------");
        System.out.print("Enter student ID to delete: ");
        String studentId = scanner.nextLine();
        boolean found = false;
    
        for (Student student : studentList) {
            if (student.getStudentId().equals(studentId)) {
                System.out.println("Found student with ID: " + studentId);
                System.out.print("Confirm delete student data? (Y/N): ");
                String confirm = scanner.nextLine();
    
                if (confirm.equalsIgnoreCase("Y")) {
                    studentList.remove(student);
                    System.out.println("Student data deleted successfully.");
                } else {
                    System.out.println("Delete operation cancelled.");
                }
                found = true;
                System.out.println("------------------------------------------");
                break;
            }
        }
    
        if (!found) {
            System.out.println("Student not found with ID: " + studentId);
        }
    }
}
