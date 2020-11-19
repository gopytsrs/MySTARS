package Control;

import Entity.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDateTime;
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
    private boolean validap;
    private Student s;
    private Admin a;
    private AccessPeriod AP = null;

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
        validap = true;
        do {

            System.out.println("Please enter your Username: ");
            sc.nextLine();
            userName = sc.nextLine();
            System.out.println("Please enter your Password: ");
            password = sc.next();
            valid = Authenticatepassword();
            if (valid == false)
                System.out.println("Invalid username/password. Please try again.");
            if (domain == "student")
            {
                validap = check_access_period(s.getSchoolName());
            }
            if (!validap)
            {
                System.out.println("The access period is"+AP.getStartDate()+" to "+AP.getEndDate()+". Current time is "+LocalDateTime.now());
            }
        } while (valid != true || validap != true);
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

    public boolean check_access_period(String schoolname)
    {
        ArrayList<School> schoolList = new ArrayList<>();
        String schoolFileName = "database_school.bin"; //purely for testing
        try {
            FileInputStream file = new FileInputStream(schoolFileName);
            ObjectInputStream in = new ObjectInputStream(file);
            schoolList = (ArrayList) in.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (School sch:schoolList)
        {
            if (schoolname.equals(sch.getSchoolName()))
            {
                AP = sch.getAccessperiod();
                break;
            }
        }
        if (AP == null)
            return false;
        else if (LocalDateTime.now().isAfter(AP.getEndDate())||LocalDateTime.now().isBefore(AP.getStartDate()))
            return false;
        else
            return true;
    }
}
