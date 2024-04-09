package Homework;

import java.util.Scanner;

class EmployeeDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Ananthichai saehui 6530613030 DE.

        Lab2_employee Em = new Lab2_employee(0, null, null, 0, 0);
        
        System.out.println("++++ Payroll System ++++");
        System.out.println("Enter employee detail");
        System.out.print("id: ");
        Em.id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("name: ");
        Em.name = scanner.nextLine();
        System.out.print("position: ");
        Em.position = scanner.nextLine();
        System.out.print("salary: ");
        Em.salary = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Enter tax rate(%) : ");
        Em.tax = scanner.nextInt();
        Em.getEmplayeeDetail();
    }
    
}
