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

        return userName;
    }
    public String getPassword()
    {

        return password;
    }
    public String getDomain()
    {
        return domain;
    }
    public Login()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your Username: ");
        userName = sc.next();
        Console C = System.console();
        char[] pw = C.readPassword("Please enter your Password: ");
        password = new String(pw);
        System.out.println("Please enter the domain(Student/Admin): ");
        domain = sc.next();
        AccountsFromDatabase(domain);
    }
    private void AccountsFromDatabase(String domain){
        String filename = domain+".txt";
        try{
            File Accountdata = new File(filename);
            Scanner reader = new Scanner(Accountdata);
            while (reader.hasNextLine()){
                String
            }

        } catch (FileNotFoundException e){
            System.out.println("Error in finding file");
            e.printStackTrace();
        }
    }
    private boolean Authenticatepassword(){

    }
}
