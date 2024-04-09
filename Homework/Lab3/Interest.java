package Homework.Lab3;

public class Interest {
    public static void main(String[] args) {
        double deposit = 10000.0;
        int years = 10;
        double annually = 0.05;
        calculateInterest(deposit, years, annually);
    }
    // Ananthichai saehui 6530613030 DE.
    public static void calculateInterest(double deposit, int years, double annually) {
        System.out.println("Year\tInterest\tBalance");
        System.out.println("-------------------------------");

        for (int year = 1; year <= years; year++) {
            double interest = deposit * annually;
            deposit += interest;

            System.out.format("%d\t%.2f\t\t%.2f%n", year, interest, deposit);
        }
    }
}
