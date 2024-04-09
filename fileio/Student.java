package fileio;

import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String name;
    private double gpa;

    public Student(){} //default constructor

    public Student(int sid, String name, double gpa){
        this.id = sid;
        this.name = name;
        this.gpa = gpa;
    }
    public String toString(){
        return id + " " + name +" " + gpa;
    }
}

