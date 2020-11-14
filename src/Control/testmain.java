package Control;

import Control.Login;

public class testmain {
    public static void main(String args[]){
        Login Log = new Login();
        String domain = Log.getDomain();
        if (domain.equals("student"))
        {
            //open the display for student
            System.out.println("Student");
        }
        else if (domain.equals("admin"))
        {
            //open the display for admin
            System.out.println("admin");
        }
    }

}
