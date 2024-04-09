package Lab9;

import java.util.Scanner;

public class AddofStudent {
    public static void main(String[] args) {
        Address address = new Address("123/45", "Main Street", "Kathu", "Phuket", 12345);
        Student student = new Student(653030, "Ananthichai", "DE");
        student.setAddress(address);

        System.out.println(student);
        System.out.println(student.address.getAddress());
        System.out.println("");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new street: ");
        String newStreet = scanner.nextLine();
        address.setStreet(newStreet);

        student.address.setStreet(newStreet);

        System.out.println(student.address.getAddress());
//Ananthichai Saehui 6530613030 DE.
        GradStudent gradStudent = new GradStudent(653030, "Ananthichai", "DE");
        gradStudent.setAddress(address);
        gradStudent.address.setStreet(newStreet);

        System.out.println("");
        System.out.println(gradStudent);
        System.out.println(gradStudent.address.getAddress());

        scanner.close();
    }
}
