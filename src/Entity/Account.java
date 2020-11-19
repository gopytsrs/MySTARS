package Entity;

import Entity.encrypt;
import java.io.Serializable;

public class Account implements Serializable {
    private String username;
    private String password;
    private String accountType;

    public Account(String username, String password, String accountType) {
        setUsername(username);
        try{
            String hashed = encrypt.getSaltedHash(password);
            setPassword(hashed);
        }catch(Exception E)
        {
            System.out.println("password setting error");
            return;
        }
        setAccountType(accountType);
    }

    public boolean validate(String username, String password){

        if (!(username.equals(this.username)))
            return false;
        else if (!encrypt.check(password,this.password))
            return false;
        else
            return true;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
