package Homework;

import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);

        System.out.print("Enter your studentID : ");
        long studentID = Sc.nextLong();
        Sc.nextLine();
        System.out.print("Enter your name : ");
        String name = Sc.nextLine();
        System.out.print("Enter your heigh : ");
        double heigh = Sc.nextDouble();
        Sc.nextLine();
        System.out.print("Enter your age : ");
        int age = Sc.nextInt();
        Sc.nextLine();

        System.out.println("============================");

            //Ananthichai Saehui 6530613030 DE.

        System.out.println("Your student data");

        System.out.println("Student ID : " + studentID);
        System.out.println("Name : " + name);
        System.out.println("Heigh : " + heigh);
        System.out.println("Age : " + age);

        Sc.close();
    }
}
