package Homework.Lab3;

import java.util.Scanner;

public class bodyMass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Name: ");
        scanner.nextLine();

        System.out.print("Enter gender [M|F]: ");
        scanner.nextLine().charAt(0);

        System.out.print("Enter birth place: ");
        scanner.nextLine();

        System.out.println("===== BMI Calculator =====");
        System.out.print("Weight (kg): ");
        double weight = scanner.nextDouble();

        System.out.print("Height (cm): ");
        double height = scanner.nextDouble();

        double bmi = calculateBMI(weight, height);
        String healthStatus = determineHealthStatus(bmi);

        System.out.println("Body Mass Index = " + bmi);
        System.out.println("Health status: " + healthStatus);

        scanner.close();
    }

    // Ananthichai saehui 6530613030 DE.

    public static double calculateBMI(double weight, double height) {
        double bmi = weight / Math.pow(height / 100, 2);
        return bmi;
    }

    public static String determineHealthStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return "Healthy";
        } else if (bmi >= 25 && bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
