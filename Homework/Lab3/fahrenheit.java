package Homework.Lab3;

import java.util.Scanner;

public class fahrenheit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("++++++ Calculater Celsius Program ++++++");
        System.out.println("  Enter 'exit' to exit the program.");

        while (true) {
            System.out.print("Enter degree (Fahrenheit): ");
            String input = scanner.nextLine();
        
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exited the program.");
                break;
            } 
            
            try {
                double fahrenheit = Double.parseDouble(input);
                
                if (fahrenheit >= 999) {
                    System.out.println("Exited the program.");
                    break;
                }
                
                double celsius = (fahrenheit - 32) * 5 / 9;
                System.out.printf("%.1f Fahrenheit = %.1f Celsius%n", fahrenheit, celsius);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number or 'exit' to close the program.");
            }
        }
// Ananthichai saehui 6530613030 DE.
        scanner.close();
        System.out.println("Created by Ananthichai eiei.");
    }
}
