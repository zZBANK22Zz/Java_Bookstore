package Lab8;

class SalaryEmployee extends Employee {
    private long ssn;
    private double salary;

    public SalaryEmployee(int empId, String empName, String position, long ssn, double salary) {
        super(empId, empName, position);
        this.ssn = ssn;
        this.salary = salary;
    }

    public long getSsn() {
        return ssn;
    }   

    public double getSalary() {
        return salary;
    }

    public void calculateSocialTax() {
        double socialTax = (salary <= 1000) ? 20 : (salary * 0.05);
        System.out.println("Social Tax = " + socialTax);
    }
//Ananthichai Saehui 6530613030 DE.
    public void printSalarySlip() {
        System.out.println("**** Salary Slip ****");
        super.displayEmployeeDetails();
        System.out.println("SSN: " + ssn);
        System.out.println("Salary: " + salary);
        calculateSocialTax();
        double netSalary = salary - ((salary <= 1000) ? 20 : (salary * 0.05));
        System.out.println("Net salary = " + netSalary);
    }
}
