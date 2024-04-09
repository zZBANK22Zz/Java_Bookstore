package Exercise.student;

class StudentDemo {
    public static void main(String[] args) {
        Student john = new Student(1,"John", "DE");
        john.regist(2, 2023);

        System.out.println("Name: " + john.name);
        System.out.println("Major: " + john.major);
        System.out.println("Semeter: " + john.semeter+"/"+ john.year);

        john.payRegistFee();
        //Ananthichai Saehui 6530613030 DE

        Student bank = new Student(2, "bank", "DE");
        bank.regist(2, 2023);

        System.out.println("Name: " + bank.name);
        System.out.println("Major: " + bank.major);
        System.out.println("Semeter: " + bank.semeter+"/"+ bank.year);

        bank.notpayRegistFee();

    }
}
