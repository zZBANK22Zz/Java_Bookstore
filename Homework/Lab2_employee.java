package Homework;

class Lab2_employee {
    int id;
    String name;
    String position;
    double salary;
    int tax;

    public Lab2_employee(int Em_id, String name, String position, double salary, int tax){
        this.id = Em_id;
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.tax = tax;
    }

    public double calculateTax(){
        return (tax/100.0) * salary;
    }

    public double calculateNet(){
        return (salary - calculateTax());
    }

    //Ananthichai saehui 6530613030 DE.

    public void getEmplayeeDetail(){
        System.out.println("========================");
        System.out.println("        Detail      ");
        System.out.println("id: " + id +" "+"Name: " + name);
        System.out.println("Position: " + position);
        System.out.println("========================");
        System.out.println("salary: " + salary);
        System.out.println("Tax " + tax + "%: " + calculateTax());
        System.out.println("Net Salary: " + calculateNet());
        System.out.println();
    }
}
