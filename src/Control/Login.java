package Control;
import Entity.Account;
import java.io.*;
import java.util.*;
public class Login {
    private String userName;
    private String password;
    private String domain;
    private ArrayList<Account> Accountlist;
    private boolean valid;
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
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter your Username: ");
            userName = sc.next();
            Console C = System.console();
            char[] pw = C.readPassword("Please enter your Password: ");
            password = new String(pw);
            System.out.println("Please enter the domain(Student/Admin): ");
            domain = sc.next();
            AccountsFromDatabase(domain);
            valid = Authenticatepassword();
            if (valid == false)
                System.out.println("Invalid username/password. Please try again.");
        }while(valid != true);
        if (domain.equals("student"))
        {
            //open the display for student
        }
        else if (domain.equals("admin"))
        {
            //open the display for admin
        }
    }
    private void AccountsFromDatabase(String domain){
        String filename = domain+".txt";                //filename will be student.txt or admin.txt
        Accountlist = new ArrayList<Account>();
        try{
            File AccountData = new File(filename);
            Scanner reader = new Scanner(AccountData);
            while (reader.hasNextLine()){
                String line = reader.nextLine();
                String[] token = line.split(" ");       // splitting the string to get username and password
                if(token.length!=2){throw new IllegalArgumentException();} //exception is thrown if the line contains anything more or less than a username and password
                Account A = new Account(token[0],token[1],domain);      //creating an Account object
                Accountlist.add(A);     //adding all the Account objects into and array list
            }

        } catch (FileNotFoundException e){
            System.out.println("Error in finding file");
            e.printStackTrace();
        }
    }
    private boolean Authenticatepassword(){
        int size = Accountlist.size();
        for (int i = 0; i<size; i++)
        {
            Account B = Accountlist.get(i);
            boolean v = B.validate(this.userName,this.password);
            if (v = true)
                return true;
        }
        return false;
    }
}
