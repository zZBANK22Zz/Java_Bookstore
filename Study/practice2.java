package Study;

import java.util.InputMismatchException;
import java.util.Scanner;

public class practice2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter a:");
            int a = sc.nextInt();
            System.out.print(a);
            System.out.print("Enter b:");
            int b = sc.nextInt();
            System.out.print(b);
            System.out.println("a/b = " + (a / b));
            System.out.println("a*b = "+ (a*b));
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter integers only.");
            sc.next();
        } finally {
            System.out.print("End of program.");
        }
    }
}
