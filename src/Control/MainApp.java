package Control;

import Entity.Admin;
import Entity.Student;

public class MainApp {
    public static void main(String args[]) {
        while (true) {
            Login Log = new Login();
            String domain = Log.getDomain();
            if (domain.equals("student")) {
                //open the display for student
                //System.out.println("Student");
                Student stud = Log.getStudent();
                StudentUI sUI = new StudentUI(stud);
                System.out.println("Hello, " + Log.getUserName() + ". What would you like to do today?");
                sUI.studentMenu();

            } else if (domain.equals("admin")) {
                //open the display for admin
                //System.out.println("admin");
                Admin admin = Log.getAdmin();
                AdminUI aUI = new AdminUI(admin);
                System.out.println("Hello, " + Log.getUserName() + ". What would you like to do today?");
                aUI.adminMenu();
            }
        }
    }

}
