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
        Scanner sc = new Scanner(System.in);
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
        }while(domaindata != 1 && domaindata != 2);
        AccountsFromDatabase(domain);                   //missing accessperiod check need read student file
        do {
            System.out.println("Please enter your Username: ");
            userName = sc.next();
            //System.out.println("Please enter your Password: ");
            //Console C = System.console();
            //char[] pw = {};
            //pw = C.readPassword();   //find anther way to mask
            //password = new String(pw);
            System.out.println("Please enter your Password: ");
            password = sc.next();
            valid = Authenticatepassword();
            if (valid == false)
                System.out.println("Invalid username/password. Please try again.");
        }while(valid != true);
    }
    private void AccountsFromDatabase(String domain){
        String filename = domain+".txt";                //filename will be student.txt or admin.txt
        Accountlist = new ArrayList<Account>();
        try{
            File AccountData = new File(filename);      //file will be in main page
            Scanner reader = new Scanner(AccountData);
            while (reader.hasNextLine()){
                String line = reader.nextLine();
                String[] token = line.split(" ");       // splitting the string to get username and password
                if(token.length!=2){throw new IllegalArgumentException();} //exception is thrown if the line contains anything more or less than a username and password
                Account A = new Account(token[0],token[1],domain);      //creating an Account object
                Accountlist.add(A);     //adding all the Account objects into an array list
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
            if (v == true)
                return true;
        }
        return false;
    }
}
