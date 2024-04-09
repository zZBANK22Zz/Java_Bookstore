package Homework.Lab4;

import java.util.Random;
import java.util.Scanner;


public class lotteryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int[][] PRIZES = {
                {1000},
                {500, 500, 500},
                {200, 200, 200, 200, 200},
                {50, 50, 50, 50, 50, 50, 50, 50, 50, 50}
        };
        final int MAX_VALUE = 100;

        while (true) {
            int[][] lotteryNumbers = generateLotteryNumbers(PRIZES, MAX_VALUE);
            
            System.out.print("Enter a number between 1 and 100 (or 999 to exit): ");
            int userInput = scanner.nextInt();

            if (userInput == 999) {
                System.out.println("bye.");
                break;
            }

            boolean found = false;
            for (int i = 0; i < lotteryNumbers.length; i++) {
                for (int j = 0; j < lotteryNumbers[i].length; j++) {
                    if (lotteryNumbers[i][j] == userInput) {
                        System.out.printf("Congratulations: you got %s prize: $%d%n", getOrdinal(j + 1), PRIZES[i][j]);
                        System.out.printf("Found at lotto[%d][%d]%n", i + 1, j + 1);
                        found = true;
                        printArray(lotteryNumbers);
                        break;
                    }
                }
                if (found) {
                    break;
                }
            }
            if (!found) {
                System.out.println("You are not lucky today");
                printArray(lotteryNumbers);
            }
            System.out.println();
        }
        scanner.close();
    }

    private static int[][] generateLotteryNumbers(int[][] prizes, int maxValue) {
        Random random = new Random();
        int[][] lotteryNumbers = new int[prizes.length][];
        for (int i = 0; i < prizes.length; i++) {
            lotteryNumbers[i] = new int[prizes[i].length];
            for (int j = 0; j < prizes[i].length; j++) {
                lotteryNumbers[i][j] = random.nextInt(maxValue) + 1;
            }
        }
        return lotteryNumbers;
    }

    //Ananthichai saehui 6530613030 DE.
    private static void printArray(int[][] array) {
        System.out.println("1st prize: " + array[0][0]);
        System.out.print("2nd prize: ");
        for (int i = 0; i < array[1].length; i++) {
            System.out.print(array[1][i] + " ");
        }
        System.out.println();
        System.out.print("3rd prize: ");
        for (int i = 0; i < array[2].length; i++) {
            System.out.print(array[2][i] + " ");
        }
        System.out.println();
        System.out.print("4th prize: ");
        for (int i = 0; i < array[3].length; i++) {
            System.out.print(array[3][i] + " ");
        }
        System.out.println();
    }


    private static String getOrdinal(int number) {
        int remainder10 = number % 10;
        int remainder100 = number % 100;
        if (remainder10 == 1 && remainder100 != 11) {
            return number + "st";
        } else if (remainder10 == 2 && remainder100 != 12) {
            return number + "nd";
        } else if (remainder10 == 3 && remainder100 != 13) {
            return number + "rd";
        } else {
            return number + "th";
        }
    }
    
}
