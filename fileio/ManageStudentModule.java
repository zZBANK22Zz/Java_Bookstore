package fileio;
import java.io.*;
import java.util.ArrayList;

public class ManageStudentModule {
        static ArrayList<Student> list = new ArrayList<Student>();
        static String filename = "studentList.dat";

        public static void main(String[] args) throws ClassNotFoundException {
            ManageStudentModule mgt = new ManageStudentModule();
            mgt.initStudentArrayList();
            mgt.saveStudentArrayList();
            mgt.readStudentArrayList();
    }

        public void initStudentArrayList(){
            Student std1 = new Student(1111, "Anna", 3.5);
            Student std2 = new Student(2222, "Bella", 2.8);
            Student std3 = new Student(3333, "Carol", 3.0);
            Student std4 = new Student(4444, "Michael", 3.8);

            list.add(std1);
            list.add(std2);
            list.add(std3);
            list.add(std4);

        }

        public void saveStudentArrayList(){
            try {
//save data to file
                ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename));
                outputStream.writeObject(list);
                System.out.println("Save student list to file "+filename + " successfully.");

            } catch (FileNotFoundException e) {
                System.out.println("Cannot file data file " + filename);
            } catch (IOException e) {
                System.out.println("Problem with file input.");
            }
        }

        public void readStudentArrayList(){
                try {
//read data from file
                    ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename));
                    Object obj = inputStream.readObject();
                    ArrayList<Student> listFromFile = (ArrayList<Student>) obj;
                    for (Student std : listFromFile){
                        System.out.println(std.toString());
                    }

                } catch (FileNotFoundException e) {
                    System.out.println("Cannot file data file " + filename);
                } catch (IOException e) {
                    System.out.println("Problem with file input.");
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            System.out.println("End of file.");
        }


}
