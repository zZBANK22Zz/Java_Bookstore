package Lab8;

class Employee {
    protected int empId;
    protected String empName;
    protected String position;

    public Employee(int empId, String empName, String position) {
        this.empId = empId;
        this.empName = empName;
        this.position = position;
    }
//Ananthichai Saehui 6530613030 DE.
    public void displayEmployeeDetails() {
        System.out.println("Id: " + empId);
        System.out.println("Name: " + empName);
        System.out.println("Position: " + position);
    }
}
   
