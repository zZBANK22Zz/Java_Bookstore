package Homework.Lab5.GPA;

class Student {
    private String id;
    private String name;
    private double gpa;

    public Student(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    //Ananthichai saehui 6530613030 DE.

    public void printStudentInfo() {
        System.out.println("Student ID: " + id + " Name: " + name + " GPA: " + gpa);
    }

    public String getStudentId(){
        return id;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}
