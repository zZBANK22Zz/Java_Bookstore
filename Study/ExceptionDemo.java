package Study;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = {4, 3, 8, 10, 22, 40, 12, 55, 60, 88, 7};
        System.out.println("Searching data in an array....");
        try {
            System.out.print("Enter index of the element:");
            int index = sc.nextInt();

            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i] + " " + (arr[i] / i));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds exception occurred.");
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic exception occurred: division by zero.");
        } catch (InputMismatchException e) {
            System.out.println("Input mismatch exception occurred: please enter an integer.");
            sc.next(); // consume the invalid input
        } catch (Exception e) {
            System.out.println("An unexpected exception occurred: " + e.getMessage());
        } finally {
            System.out.println("End of program.");
        }
    }
}
