package Control;

import Entity.*;

import java.io.Console;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    /**
     * Username of the user.
     */
    private String userName;
    /**
     * Password of the user.
     */
    private String password;
    /**
     * Domain of the user.
     */
    private String domain;
    /**
     * An arraylist/collection of all the accounts.
     */
    private ArrayList<Account> Accountlist;
    /**
     * An arraylist/collection of all the students.
     */
    private ArrayList<Student> studentList;
    /**
     * An arraylist/collection of all the admins.
     */
    private ArrayList<Admin> adminList;
    /**
     * A boolean variable that is true only when username and password is matching and correct. Otherwise, it is false.
     */
    private boolean valid;
    /**
     * A boolean variable that is true only when the DateTime now is within the access period.
     */
    private boolean validap;
    /**
     * An object of a student.
     */
    private Student s;
    /**
     * An object of an admin.
     */
    private Admin a;
    /**
     * The access period given to the students.
     */
    private AccessPeriod AP = null;

    Console console = System.console();
    Scanner sc = new Scanner(System.in);

    /**
     * Gets the username of this user.
     * @return the username.
     */
    public String getUserName() {

        return userName;
    }

    /**
     * Gets the password of this user.
     * @return the password.
     */
    public String getPassword() {

        return password;
    }

    /**
     * Get the domain of this user.
     * @return the domain.
     */
    public String getDomain() {
        return domain;
    }

    /**
     * A constructor for the class login.
     */
    public Login() {
        AccountsFromDatabase();
        collectDomain();

        //missing accessperiod check need read student file
        validap = true;
        do {
            if(domain=="admin") validap = true;
            System.out.println("Please enter your Username: ");
            userName = sc.nextLine();
//            char [] pw = console.readPassword("Please enter your password:\n");
//            password = new String(pw);
            System.out.println("Enter your password");
            password = sc.nextLine();
            valid = Authenticatepassword();
            if (valid == false) {
                System.out.println("Invalid username/password. Please try again.");
                continue;
            }
            if (domain == "student")
            {
                validap = check_access_period(s.getSchoolName());
            }
            if (!validap)
            {
                System.out.println("The access period is "+AP.getStartDate()+" to "+AP.getEndDate()+". Current time is "+LocalDateTime.now());
                collectDomain();
            }
        } while (valid != true || validap != true);
    }

    /**
     * A method that splits the user into admin or student login page, based on what they have chosen.
     */
    private void collectDomain() {
        int domaindata = -1;
        do {
            System.out.println("Please enter the domain(student/admin): ");
            System.out.println("Key in 1 for student");
            System.out.println("Key in 2 for admin");
            try{
                String dummy = sc.nextLine();
                domaindata = Integer.parseInt(dummy);
            }catch(Exception E){
                System.out.println("Please key in integer");
                continue;
            }
            if (domaindata == 1)
                domain = "student";
            else if (domaindata == 2)
                domain = "admin";
            else
                System.out.println("Your input was invalid. Please try again.");
        } while (domaindata != 1 && domaindata != 2);
    }

    /**
     * A method that gets the accounts from the specific binary file.
     * @param domain Domain to get the accounts.
     */
    private void AccountsFromDatabase() {                                       // change to binary file
        String filename = "database_student.bin";
        Accountlist = new ArrayList<Account>();

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
        adminList = new ArrayList<>();
        filename = "database_admin.bin";
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

    /**
     * A boolean method that authenticates the password.
     * @return true if the username and password matches and is correct.
     */
    private boolean Authenticatepassword() {
        int size = Accountlist.size();
        for (int i = 0; i < size; i++) {
            Account B = Accountlist.get(i);
            boolean v = B.validate(this.userName, this.password);
            if (v == true) {
                if (domain.equals("student")) {
                    this.s = studentList.get(i);
                } else {
                    this.a = adminList.get(0);
                }
                return true;
            }

        }
        return false;
    }

    /**
     * Gets the student object if the user is a student.
     * @return the student object.
     */
    public Student getStudent() {
        return this.s;
    }

    /**
     * Gets the admin object if the user is an admin.
     * @return the admin object.
     */
    public Admin getAdmin() {
        return this.a;
    }

    /**
     * A method to check the access period.
     * @param schoolname The school name of the user.
     * @return true if the current date time is within the access period.
     */
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
