package Control;

import Entity.Admin;
import Entity.Student;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class makeStudent {
    public static void main(String args[]) throws Exception {
        ArrayList<Student> S = new ArrayList<>();
        Student student = new Student("Sean Goh", "U1920001", "seangoh@e.ntu.edu.sg", 2,"School of Computer Science and Engineering", "Male", "Singaporean");
        S.add(student);
        String fileName = "database_student.bin";
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream os = new ObjectOutputStream(fileOut);
            os.writeObject(S);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
}}
