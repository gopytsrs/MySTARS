package Control;

import Entity.Admin;
import Entity.Student;

import java.io.*;
import java.util.ArrayList;

public class makedataAdmin {
    public static void main(String args[]) throws Exception {
        ArrayList<Admin> A = new ArrayList<>();
        Admin ad = new Admin("admin");
        A.add(ad);
        String fileName = "database_admin.bin";
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream os = new ObjectOutputStream(fileOut);
            os.writeObject(A);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //ArrayList<Student> studentList = new ArrayList<>();

        /*String fileName = "database_student.bin";
        
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
        }*/
    }
}
