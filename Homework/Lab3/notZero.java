package Homework.Lab3;

public class notZero {
    public static void main(String[] args) {
        randomNotZeroEnding();
    }
    // Ananthichai saehui 6530613030 DE.
    public static void randomNotZeroEnding(){
        java.util.Random random = new java.util.Random();
        int num = 0;

        while (num < 10) {
            int randomNum = random.nextInt(101);
            if (randomNum % 10 != 0){
                System.out.println("Random numder : " + randomNum);
                num++;
            }
        }
    }
}
