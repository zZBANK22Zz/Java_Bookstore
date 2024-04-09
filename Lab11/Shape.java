package Lab11;

public class Shape {
    public void draw(){
        System.out.println("Drawing a shape");
    }
    public void erase(){

    }
}
/**************************/
class Circle extends Shape {
      int radius;
      public Circle(int radius) {
          this.radius = radius;
      }

      public void draw() {
          System.out.println("Drawing a circle");

      }
      public void erase() {

      }

      public void calculateArea() {
          System.out.println("Area = " + (Math.PI * radius * radius));
      }
}
/**************************/
class Triangle extends Shape {
    int base;
    int height;
    public Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }
    public void draw() {
        System.out.println("Drawing a triangle");
    }
    
    public void erase() {

    }
}
/**************************/


