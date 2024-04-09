package Exercise.bankAcc;

import java.util.Scanner;

class BankAccoutDemo {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            BankAccout A = new BankAccout(0, 0, null);
            BankAccout B = new BankAccout(0, 0, null);
            System.out.print("Enter your Bank ID: ");
            A.id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter your name: ");
            A.name = scanner.nextLine();
            A.balance = 0;
            A.printInfo();
            System.out.print("Enter your Bank ID: ");
            B.id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter your name: ");
            B.name = scanner.nextLine();
            B.balance = 0;
            B.printInfo();
            
            System.out.println("Enter [w] for withdraw");
            System.out.println("Enter [d] for Deposit");
            System.out.println("Enter [c] for Check Balance");
            System.out.println("Enter [other] for Cancle");
            System.out.println("=============================");

                //Ananthichai Saehui 6530613030 DE

            char menu;
            do{
                Scanner scan = new Scanner(System.in);
                System.out.print("Enter your menu: ");
                menu = scan.next().charAt(0);

                    switch (menu){
                        case 'w' :
                            System.out.print("Enter withdraw money: ");
                            B.withdraw = scan.nextDouble();
                            B.balance = B.balance - B.withdraw;
                            break;
                        case 'd' :
                            System.out.print("Enter deposit money: ");
                            B.deposit = scan.nextDouble();
                            B.balance = B.balance + B.deposit;
                            break;
                        case 'c' :
                            System.out.println("Current balance : " + B.balance);
                            break;
                        default :
                            break;
                    }
            }while( menu == 'w' || menu == 'd' || menu == 'c');
        System.out.println("Thank you Bye");
    }
}
