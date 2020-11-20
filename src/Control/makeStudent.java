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
        Student student = new Student("Sean Goh", "U1920001A", "sgoh046@e.ntu.edu.sg", 2,"School of Computer Science and Engineering", "M", "Singaporean");
        Student student1 = new Student("James","U1920002K","james046@e.ntu.edu.sg",2,"School of Chemical and Biomedical Engineering","M","Singaporean");
        Student student2 = new Student("Jee Wern","U1920003C","jtchen002@e.ntu.edu.sg",2,"School of Chemical and Biomedical Engineering","M","Singaporean");

        S.add(student);
        S.add(student1);
        S.add(student2);

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
