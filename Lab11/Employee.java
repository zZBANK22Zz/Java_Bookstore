package Lab11;

abstract public class Employee {
    public String name;
    public abstract double computePay();
}
/************************************/
class Salary extends Employee{
double salary;
Salary(String n,double s){
    name = n;
    salary = s;
}
public double computePay(){
    double tax = salary*0.05;
    return salary - tax;
}
}
/************************************/
class Hourly extends Employee{
double rate ;
int hour;
Hourly(String n,double r, int h){
    name = n;
hour = h;
rate = r;
}
public double computePay(){
    return hour*rate;
}
}
/************************************/
class PersonalModule {
double pay = 0.0;
public void payment(Employee e) {
    if (e instanceof Hourly) {
        pay = e.computePay();
        System.out.println("Hourly Employee: "+ e.name );
        System.out.println("Work " + ((Hourly) e).hour + " hrs., Wage: " + pay);
    }
    if (e instanceof Salary) {
        pay = e.computePay();
        System.out.println("Salary Employee: " + e.name);
        System.out.println("Net salary: " + pay);
    }
}
}
/************************************/

class PayDemo {
public static void main(String[] args) {
    Hourly h = new Hourly("John", 100, 10);
    Salary s = new Salary("Jane", 10000);
    PersonalModule p = new PersonalModule();
    p.payment(h);
    p.payment(s);
}
}

