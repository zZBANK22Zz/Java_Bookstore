package Lab8;

class HourlyEmployee extends Employee {
    private double wageRate;
    private double hoursWorked;

    public HourlyEmployee(int empId, String empName, String position, double wageRate, double hoursWorked) {
        super(empId, empName, position);
        this.wageRate = wageRate;
        this.hoursWorked = hoursWorked;
    }

    public void setWageRate(double wageRate) {
        this.wageRate = wageRate;
    }
//Ananthichai Saehui 6530613030 DE.
    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getWageRate() {
        return wageRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public double calculateEarnings() {
        if (hoursWorked <= 40) {
            return wageRate * hoursWorked;
        } else {
            double normalPay = wageRate * 40;
            double overtimePay = (hoursWorked - 40) * wageRate * 1.5;
            return normalPay + overtimePay;
        }
    }

    public void printPaymentSlip() {
        System.out.println("**** Hourly Slip ****");
        super.displayEmployeeDetails();
        System.out.println("Worked hours = " + hoursWorked);
        System.out.println("Wage rate = " + wageRate);
        System.out.println("Earnings = " + calculateEarnings());
    }
}

