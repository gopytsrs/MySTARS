package Control;

import Entity.Student;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class makedataAdmin {
    public static void main(String args[]) {
        //Admin ad = new Admin("admin");
        ArrayList<Student> studentList = new ArrayList<>();

        String fileName = "database_student.bin";
        
        try {
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(file);
            studentList = (ArrayList) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (Student s : studentList) {
            System.out.println(s.getAccount().getUsername());
            System.out.println(s.getAccount().getPassword());
        }
    }
}
