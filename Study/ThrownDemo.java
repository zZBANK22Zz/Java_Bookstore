package Study;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ThrownDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter number (1-4) :");
            int n = sc.nextInt();
            switch(n) {
                case 1:
                    System.out.println("1st case");
                    break;
                case 2:
                    System.out.println("2nd case");
                case 3:
                    System.out.println("3rd case");
                    throw new RuntimeException("RuntimeException!");
                case 4:
                    System.out.println("4th case");
                    throw new Exception("Exception!");
                default:
                    throw new InputMismatchException("the number must be 1-4.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        } finally {
            System.out.print("End of program.");
        }
    }
}
