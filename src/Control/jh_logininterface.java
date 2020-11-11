package Control;
import java.util.*;
import java.io.*;
public class jh_logininterface {
    private String username;
    private String password;
    loginController lc = new loginController();
    public loginInterface() {
        Console console = System.console();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your username:");
        username = sc.nextLine();
        char[] pw = console.readPassword("Enter password");
        password = new String(pw);
        System.out.println(password);
        lc.checkAccount(username, password);
    }
    public void printInputError()
    {
        System.out.println("Your username or password is incorrect");
    }
    public void printTimingError()
    {
        System.out.println("Your entry is not within the timing you are allocated ");
    }
}
