package Lab11;

import java.util.LinkedList;

public class PayDemo {
    public static void main(String[] args) {
        Hourly h = new Hourly("John", 100, 10);
        Salary s = new Salary("Jane", 10000);
        PersonalModule p = new PersonalModule();
        p.payment(h);
        p.payment(s);

        LinkedList <Employee> emplist = new LinkedList<>();
        emplist.add(h);
        emplist.add(s);

        emplist.add(new Hourly("Ann", 200, 8));
        emplist.add(new Salary("Joe", 25000));

        System.out.println("*******Summary payment********");

      for (Employee emp : emplist) {
          System.out.println(emp.name + " " + emp.computePay());
      }

        System.out.println("******Payment Detail******");
        for (Employee emp : emplist) {
            p.payment(emp);
            System.out.println("-------------------------------");
        }
    }
}
