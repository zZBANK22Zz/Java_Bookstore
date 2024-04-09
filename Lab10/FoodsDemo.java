package Lab10;

import java.util.Scanner;

public class FoodsDemo { 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Food f = new Food("Avocado", 2.0, 160);
        f.display();
        System.out.println(" ");
        Toy t = new Toy("Barbie doll", 20.0, 3);
        t.display();
        System.out.println("-----------------------------------------------");
        Food foods = new Food("Apple", 1.0, 50.0);
        foods.display();
        System.out.println("-----------------------------------------------");

        //Ananthichai Saehui 6530613030 DE.
        System.out.println("Enter the details for a new food: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Price: ");
        double price = sc.nextDouble();
        System.out.print("Calories: ");
        double calories = sc.nextDouble();

        Food food = new Food(name, price, calories);
        food.display();

        sc.close();

        System.out.println("-----------------------------------------------");
        Book H = new Book("Ananthichai", 10.0, "Hong");
        H.display();
    }
}