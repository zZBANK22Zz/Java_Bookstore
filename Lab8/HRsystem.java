package Lab8;

import java.util.Scanner;

public class HRsystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("*** Insert Salary Employee Data ****");
        System.out.print("Id: ");
        int salaryEmpId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name: ");
        String salaryEmpName = scanner.nextLine();
        System.out.print("Position: ");
        String salaryPosition = scanner.nextLine();
        System.out.print("SSN: ");
        long ssn = scanner.nextLong();
        System.out.print("Salary: ");
        double salary = scanner.nextDouble();
        System.out.println("\n");

        SalaryEmployee salaryEmployee = new SalaryEmployee(salaryEmpId, salaryEmpName, salaryPosition, ssn, salary);
        salaryEmployee.printSalarySlip();
        System.out.println("\n");
//Ananthichai Saehui 6530613030 DE.
        System.out.println("*** Insert Hourly Employee Data ****");
        System.out.print("Id: ");
        int hourlyEmpId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name: ");
        String hourlyEmpName = scanner.nextLine();
        System.out.print("Position: ");
        String hourlyPosition = scanner.nextLine();
        System.out.print("Wage rate: ");
        double wageRate = scanner.nextDouble();
        System.out.print("Worked hours: ");
        double hoursWorked = scanner.nextDouble();

        HourlyEmployee hourlyEmployee = new HourlyEmployee(hourlyEmpId, hourlyEmpName, hourlyPosition, wageRate, hoursWorked);

        System.out.println("\n");
        hourlyEmployee.printPaymentSlip();

        scanner.close();
    }
}
