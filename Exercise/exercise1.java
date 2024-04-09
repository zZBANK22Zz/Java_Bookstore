package Exercise;

public class exercise1 {
    public static final double PI = 3.1416;
    public static void main(String[] args) {
        double radius = 10;
        double areaOfcircle = calculateCircleArea(radius);
        double volumeOfsphere = calculateVolume(radius);


        System.out.println("The radius of circle : " + radius);
        System.out.println("The area of circle : " + areaOfcircle);
        System.out.println("The volume of circle : " + volumeOfsphere);
    }

        //Ananthichai Saehui 6530613030 DE.

    public static double calculateCircleArea(double radius){
        return PI * radius * radius;
    }
    public static double calculateVolume(double radius){
        return (4.0/3.0) * PI * radius * radius * radius;
    }
}
