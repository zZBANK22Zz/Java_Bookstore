package Homework.Lab3;

import java.util.Scanner;

public class Grade {
    public static void calculateGrade() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter name (type 'exit' to stop): ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("exit")) {
                System.out.println("Exit the program");
                break;
            }
            System.out.print("Enter score: ");
            int score = scanner.nextInt();
            scanner.nextLine();
    
            if (isValidScore(score)) {
                char grade = calculateScore(score);
                System.out.println("Grade: " + grade);
            } else {
                System.out.println("Invalid score.");
            }
        }
        scanner.close();
    }

    // Ananthichai saehui 6530613030 DE.

    public static boolean isValidScore(int score) {
        return score >= 0 && score <= 100;
    }

    public static char calculateScore(int score) {
        if(score >= 85 && score <= 100){
            return 'A';
        } else if (score >= 75 && score <= 84) {
            return 'B';            
        } else if (score >=65 && score <=74){
            return 'C';
        } else if (score >= 55 && score <= 64){
            return 'D';
        } else {
            return 'F';
        }
    }

    public static void main(String[] args) {
        calculateGrade();

    }
}
