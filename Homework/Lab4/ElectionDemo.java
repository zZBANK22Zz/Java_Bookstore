package Homework.Lab4;

import java.util.Scanner;

public class ElectionDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Election election = new Election();

        System.out.print("Enter number of candidates: ");
        int numCandidates = scanner.nextInt();
        scanner.nextLine();
        election.setNumCandidates(numCandidates);

        for (int i = 0; i < numCandidates; i++) {
            System.out.printf("Enter candidate %d name: ", i + 1);
            String name = scanner.nextLine();
            System.out.printf("Enter candidate %d votes: ", i + 1);
            int votes = scanner.nextInt();
            scanner.nextLine();
            election.addCandidate(i, name, votes);
        }

        //Ananthichai saehui 6530613030 DE.

        int totalVotes = election.calcTotalVotes();
        System.out.println("==============================");
        System.out.println("Candidate         votes received           percent");
        System.out.println("==============================");
        for (int i = 0; i < numCandidates; i++) {
            double percent = ((double) election.votes[i] / totalVotes) * 100;
            System.out.printf("%-20s%-30d%.2f%%%n", election.name[i], election.votes[i], percent);
        }
        System.out.println("==============================");
        System.out.printf("Total Votes:             %-30d100.00%%%n", totalVotes);
        System.out.println("==============================");
        int winnerIndex = election.calculateWinner();
        System.out.println("Winner of the election is: " + election.name[winnerIndex]);

        scanner.close();
    }
}
