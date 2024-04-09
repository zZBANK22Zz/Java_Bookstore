package Homework.Lab5;

import java.util.Scanner;

public class subjectManagement {
    private static Subject[] subjectArray = new Subject[5];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        subjectManagement subjectManagement = new subjectManagement();

        System.out.println("* Printing all subjects *");
        for (Subject subject : subjectArray) {
            if (subject != null) {
                subject.printSubject();
            }
        }
        boolean continueAdding = true;
        while (continueAdding) {
            System.out.println("* Add new subject *");
            subjectManagement.addNewSubject(scanner);
    
            System.out.println("Do you want to add another subject? (yes/no)");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("yes")) {
                continueAdding = false;
            }
        }

        //Ananthichai saehui 6530613030

        System.out.println("");

        System.out.println("* Printing all subjects *");
        subjectManagement.printAllSubjects();

        System.out.println("");

        System.out.println("* Search a subject by subject ID *");
        subjectManagement.searchSubject(scanner);

        scanner.close();
    }

    public void addNewSubject(Scanner scanner) {
        for (int i = 0; i < subjectArray.length; i++) {
            if (subjectArray[i] == null) {
                System.out.print("Enter subject ID: ");
                String subjectId = scanner.nextLine();
                System.out.print("Enter subject name: ");
                String name = scanner.nextLine();
                System.out.print("Enter credit: ");
                int credit = scanner.nextInt();
                scanner.nextLine();

                subjectArray[i] = new Subject(subjectId, name, credit);
                System.out.println("Add 1 subject successfully: ");
                subjectArray[i].printSubject();
                break;
            }
        }
    }

    public void printAllSubjects() {
        for (Subject subject : subjectArray) {
            if (subject != null) {
                subject.printSubject();
            }
        }
}
    public void searchSubject(Scanner scanner) {
        System.out.print("Enter subject ID to search: ");
        String searchId = scanner.nextLine();
        int count = 0;
        for (Subject subject : subjectArray) {
            if (subject != null && subject.getSubjectId().contains(searchId)) {
                subject.printSubject();
                count++;
            }
        }
        System.out.println("Found " + count + " subject.");
    }
}
