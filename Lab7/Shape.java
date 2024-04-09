package Lab7;

public class Shape {

    String type;
    private String name;
    public String color;

    public Shape(String type, String name, String color) {
        this.type = type;
        this.name = name;
        this.color = color;
    }
//Ananthichai Saehui 6530613030 DE.
    public void printShape() {
        System.out.println("Type: " + type);
        System.out.println("Name: " + name);
        System.out.println("Color: " + color);
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    

    public void calculateArea(int radius) {
        System.out.println("Area = " + (Math.PI * Math.pow(radius, 2))+ "\n");
        System.out.println("++ Bye ++");
    }

    public int calculateArea(int length, int width) {
        return width * length;
    }

    public double calculateArea(int side1, int side2, int side3) {
        double s = (side1 + side2 + side3) / 2;
        double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));

        return area;
    }

}
