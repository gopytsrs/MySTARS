package Control;

import Control.Login;

public class testmain {
    public static void main(String args[]){
        Login Log = new Login();
        String domain = Log.getDomain();
        if (domain.equals("student"))
        {
            //open the display for student
            //System.out.println("Student");
            StudentUI sUI = new StudentUI();
            System.out.println("Hello, " + Log.getUserName() + ". What would you like to do today?");
            sUI.studentMenu();
        }
        else if (domain.equals("admin"))
        {
            //open the display for admin
            //System.out.println("admin");
            AdminUI aUI = new AdminUI();
            System.out.println("Hello, " + Log.getUserName() + ". What would you like to do today?");
            aUI.adminMenu();
        }
    }

}
