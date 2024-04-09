package Lab11;

public class ShapePolyDemo {
    public static void main(String[] args) {
        Shape s = new Circle(5);   //reference superclass var. to subclass object = Upcast
        s.draw();
        ((Circle)s).radius = 10;

       // add code in (1) here
        s = new Triangle(4, 5);
        s.draw();
        //add code in (2) here
    }
}
