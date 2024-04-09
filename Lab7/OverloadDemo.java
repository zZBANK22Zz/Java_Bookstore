package Lab7;

import java.util.Scanner;

public class OverloadDemo {
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        OverloadDemo demo = new OverloadDemo();
        demo.showMenu();
    }
//Ananthichai Saehui 6530613030 DE.
    public void showMenu() {
        System.out.println("++ Select Shape to calculate area ++");
        System.out.println("[1]: Circle. [2]: Rectangle. [3]: Triangle");
        System.out.print("Select [1-3]: ");
    try {
        int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    calculateCircleArea();
                    break;
                case 2:
                    calculateRectangleArea();
                    break;
                case 3:
                    calculateTriangleArea();
                    break;
                default:
                    System.out.println("Invalid choice. Please select again.");
                    showMenu();
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Incorrest menu\n");
            System.out.println("++ Bye ++");
        }
    }

    public void calculateCircleArea() {
        System.out.println("++ Calculate a circle object ++");
        Shape s = new Shape("Circle", "circle", "green");
        System.out.println("Type: " + s.type + " Name: " + s.getName() + " Color: " + s.color);
        System.out.print("Enter radius of the circle: ");
        int radius = sc.nextInt();
        s.calculateArea(radius);
    }

    public void calculateRectangleArea() {
        System.out.println("++ Calculate a ractangle object ++");
        Shape s = new Shape("Ractangle", "rct", "blue");
        System.out.println("Type: " + s.type + " Name: " + s.getName() + " Color: " + s.color);
        System.out.print("Enter length of the rectangle: ");
        int length = sc.nextInt();
        System.out.print("Enter width of the rectangle: ");
        int width = sc.nextInt();
        System.out.println("Area = " + s.calculateArea(length, width) + "\n");
        System.out.println("++ Bye ++");
    }

    public void calculateTriangleArea() {
        System.out.println("++ Calculate a triagle object ++");
        Shape s = new Shape("triagle", "tri", "pink");
        System.out.println("Type: " + s.type + " Name: " + s.getName() + " Color: " + s.color);
        System.out.print("Enter side1: ");
        int side1 = sc.nextInt();
        System.out.print("Enter side2: ");
        int side2 = sc.nextInt();
        System.out.print("Enter side3: ");
        int side3 = sc.nextInt();
        System.out.println("Area = " + s.calculateArea(side1, side2, side3)+ "\n");
        System.out.println("++ Bye ++");
    }
}
