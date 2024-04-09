package fileio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class AppendStudentList {
    static String filename = ManageStudentModule.filename;
    ArrayList stdList = ManageStudentModule.list;
    public void appendStudent() {

        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename));

            Student std5 = new Student(7777, "Anna", 3.5);
            Student std6 = new Student(8888, "Bella", 2.8);
            Student std7 = new Student(9999, "Carol", 3.0);

            stdList.add(std5);
            stdList.add(std6);
            stdList.add(std7);

            outputStream.writeObject(stdList);

            outputStream.flush();
            outputStream.close();
            System.out.println("Save student data to file " + filename);
        }
        catch ( IOException e){
            System.out.println("Problem with file output.");
        }
    }
    public static void main(String[] args) throws ClassNotFoundException {

        ManageStudentModule mgt = new ManageStudentModule();
    
        mgt.initStudentArrayList();
        mgt.saveStudentArrayList();
        mgt.readStudentArrayList();
    
        System.out.println("Add student data....");
        AppendStudentList ap = new AppendStudentList();
        ap.appendStudent();
    
        System.out.println("Read data from file: "+ filename);
        mgt.readStudentArrayList();
    
    }
    
}
