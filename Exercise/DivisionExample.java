package Exercise;

public class DivisionExample {
    
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;
        
        try {
            int result = num1/num2;
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("The system cannot divide by zero.");
        }
    }
    
}
