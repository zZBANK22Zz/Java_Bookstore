package Exercise.student;

class Student {
    long studentid;
    String name;
    String major;
    int semeter;
    int year;

    public Student(long studentid, String name, String major){
        this.studentid = studentid;
        this.name = name;
        this.major = major;
    }

    public void regist(int semeter, int year){
        this.semeter = semeter;
        this.year = year;
    }
    
    public boolean payRegistFee() {
        System.out.println("Pay registration fee status: Paid");
        return true;
    }

    //Ananthichai Saehui 6530613030 DE

    public boolean notpayRegistFee(){
        System.out.println("Pay registration fee status: Not Paid");
        return false;
    }

}
