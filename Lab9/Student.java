package Lab9;

class Student {
    int sId;
    String name;
    String major;
    Address address;

    public Student(int sId, String name, String major){
        this.sId = sId;
        this.name = name;
        this.major = major;
    }
//Ananthichai Saehui 6530613030 DE.
    public String toString(){
        return sId + " " + name + " " + major;
    }

    public void setAddress(Address address){
        this.address = address;
    }
}

class GradStudent extends Student {
    GradStudent(int sId, String name, String major) {
        super(sId, name, major);
    }
}
