package Homework.Lab3;

public class Random {
    public static void main(String[] args) {
        randomUntil77();
    }
    // Ananthichai saehui 6530613030 DE.

    public static void randomUntil77() {
        java.util.Random random = new java.util.Random();
        int randomNumber;

        do {
            randomNumber = random.nextInt(95) + 5;
            System.out.println("Random Number: " + randomNumber);
        } while (randomNumber != 77);

        System.out.println("Program stopped because number 77 is generated.");
    }
}
