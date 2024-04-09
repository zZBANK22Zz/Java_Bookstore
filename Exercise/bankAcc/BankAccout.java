package Exercise.bankAcc;

class BankAccout {
    public int id;
    public double balance;
    public String name;
    public double withdraw;
    public double deposit;
    BankAccout(int aid, double balance, String name){
        this.id = aid;
        this.balance = balance;
        this.name = name;
    }

        //Ananthichai Saehui 6530613030 DE

    public void printInfo(){
        System.out.println("===========================");
        System.out.println("Bank ID: "+id);
        System.out.println("Name : "+name);
        System.out.println("Balnce : "+balance);
        System.out.println("===========================");
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }
}
