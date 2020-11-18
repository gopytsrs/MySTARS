package Control;

import Entity.Account;
import Entity.Admin;
import Entity.Student;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    private String userName;
    private String password;
    private String domain;
    private ArrayList<Account> Accountlist;
    private ArrayList<Student> studentList;
    private ArrayList<Admin> adminList;
    private boolean valid;
    private Student s;
    private Admin a;

    Scanner sc = new Scanner(System.in);

    public String getUserName() {

        return userName;
    }

    public String getPassword() {

        return password;
    }

    public String getDomain() {
        return domain;
    }

    public Login() {
        collectDomain();
        AccountsFromDatabase(domain);                   //missing accessperiod check need read student file
        do {
            System.out.println("Please enter your Username: ");
            userName = sc.nextLine();
            System.out.println("Please enter your Password: ");
            password = sc.next();
            valid = Authenticatepassword();
            if (valid == false)
                System.out.println("Invalid username/password. Please try again.");
        } while (valid != true);
    }

    private void collectDomain() {
        int domaindata;
        do {
            System.out.println("Please enter the domain(student/admin): ");
            System.out.println("Key in 1 for student");
            System.out.println("Key in 2 for admin");
            domaindata = sc.nextInt();
            if (domaindata == 1)
                domain = "student";
            else if (domaindata == 2)
                domain = "admin";
            else
                System.out.println("Your input was invalid. Please try again.");
        } while (domaindata != 1 && domaindata != 2);
    }

    private void AccountsFromDatabase(String domain) {                                       // change to binary file
        String filename = "database_" + domain + ".bin";
        Accountlist = new ArrayList<Account>();

        if (domain.equals("student")) {
            studentList = new ArrayList<Student>();
            try {
                FileInputStream file = new FileInputStream(filename);
                ObjectInputStream in = new ObjectInputStream(file);
                studentList = (ArrayList) in.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            for (Student s : studentList) {
                Accountlist.add(s.getAccount());
            }
        } else {
            adminList = new ArrayList<>();
            try {
                FileInputStream file = new FileInputStream(filename);
                ObjectInputStream in = new ObjectInputStream(file);
                adminList = (ArrayList) in.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            for (Admin a : adminList) {
                Accountlist.add(a.getAccount());
            }
        }
    }

    private boolean Authenticatepassword() {
        int size = Accountlist.size();
        for (int i = 0; i < size; i++) {
            Account B = Accountlist.get(i);
            boolean v = B.validate(this.userName, this.password);
            if (v == true) {
                if (domain.equals("student")) {
                    this.s = studentList.get(i);
                } else {
                    this.a = adminList.get(i);
                }
                return true;
            }

        }
        return false;
    }

    public Student getStudent() {
        return this.s;
    }

    public Admin getAdmin() {
        return this.a;
    }
}
