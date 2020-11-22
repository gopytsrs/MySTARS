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
        Student student3 = new Student("Jun Hao", "U1920004D", "junhao001@e.ntu.edu.sg", 2, "School of Computer Science and Engineering", "M", "Singaporean");
        Student student4 = new Student("Zhi Ying", "U1920005E", "zhiying001@e.ntu.edu.sg", 2, "Nanyang Business School", "F", "Singaporean");
        Student student5 = new Student("Wen Cheng", "U1920006F", "wencheng001@e.ntu.edu.sg", 2, "Nanyang Business School", "M", "Singaporean");
        Student student6 = new Student("Zachary Lam", "U1920007G", "zlam001@e.ntu.edu.sg", 2, "School of Computer Science and Engineering", "M", "Singaporean");
        Student student7 = new Student("Joseph Phuah", "U1920008H", "jphuah001@e.ntu.edu.sg", 2, "School of Computer Science and Engineering", "M", "Singaporean");
        Student student8 = new Student("Johnny Hsu", "U1920009I", "jhsu001@e.ntu.edu.sg", 2, "Nanyang Business School", "M", "Taiwanese");
        Student student9 = new Student("Darren Choo", "U1920010J", "dchoo001@e.ntu.edu.sg", 2, "School of Computer Science and Engineering", "M", "Singaporean");
        Student student10 = new Student("Lucas Teo", "U1920011K", "lteo001@e.ntu.ed.sg", 2, "School of Chemical and Biomedical Engineering", "M", "Singaporean");
        Student student11 = new Student("Crystal Chew", "U1920012L", "cchew001@e.ntu.edu.sg", 2, "School of Chemical and Biomedical Engineering", "F", "Singaporean");
        Student student12 = new Student("Megan Tan", "U1820013M", "mtan001@e.ntu.edu.sg", 3, "Nanyang Business School", "F", "Singaporean");
        Student student13 = new Student("Zhe Ren", "U1920014N", "zren001@e.ntu.edu.sg", 2, "School of Computer Science and Engineering", "M", "Singaporean");
        Student student14 = new Student("Ze Ming", "U1920015G", "mingz001@e.ntu.edu.sg", 2, "School of Computer Science and Engineering", "M", "China");

        S.add(student);
        S.add(student1);
        S.add(student2);
        S.add(student3);
        S.add(student4);
        S.add(student5);
        S.add(student6);
        S.add(student7);
        S.add(student8);
        S.add(student9);
        S.add(student10);
        S.add(student11);
        S.add(student12);
        S.add(student13);
        S.add(student14);

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
