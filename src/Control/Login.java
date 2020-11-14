package Control;
import Entity.Account;
import java.io.*;
import java.util.*;
public class Login {
    private String userName;
    private String password;
    private String domain;
    private ArrayList<Account>;
    public String getUserName()
    {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your Username: ");
        userName = sc.next();
        return userName;
        System.out.println("Key in 1 for Student or 2 for Admin: ");
        choice = sc.nextInt();
        if (choice == 1)
        {

        }
    }
    public String getPassword()
    {
        Console C = System.console();
        char[] pw = C.readPassword("Please enter your Password: ");
        password = new String(pw);
        return password;
    }
    public String getDomain()
    {

    }
}
