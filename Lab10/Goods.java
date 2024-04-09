package Lab10;

public  abstract class Goods {
    String description;
    double price;

    public void printGoods(){
        System.out.print("Goods: " + description + " Price: " + price + "\t");
    };
    public abstract void display();
}

class Food extends Goods{
    double calories;
    Food(String dese, double price, double cal){
        description = dese;
        this.price = price;
        calories = cal;
    }
//Ananthichai Saehui 6530613030 DE.
    Food(){}
    
    public void display(){  
        super.printGoods();
        System.out.println("Calories: "+calories+"cal/100g");
    }
}

class Toy extends Goods implements Vat{
    int minimumAge;

    public Toy(String dese, double price, int minimumAge){
        description = dese;
        this.price = price;
        this.minimumAge = minimumAge;
    }
    @Override
    public void display() {
        super.printGoods();

        System.out.println("Minimum age: " + minimumAge);
        System.out.println("VAT "+ vatRate*100+"% = $"+ this.calculateVat());
        System.out.println("Price incl.VAT = " + "$" + (price + this.calculateVat()));
    }

    @Override
    public double calculateVat(){
        return vatRate * price;  
    }
}

class Book extends Goods implements Vat{ 
    String author;

    public Book(String dese, double price, String author){
        description = dese;
        this.price = price;
        this.author = author;
    }
    @Override
    public void display() {   
        super.printGoods();

        System.out.println("Author: " + author);
        System.out.println("VAT "+ vatRate*100+"% = $"+ this.calculateVat());
        System.out.println("Price incl.VAT = " + "$" + (price + this.calculateVat()));
    }

    @Override
    public double calculateVat(){
        return vatRate * price; 
    }
}