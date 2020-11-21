package Entity;

import Entity.encrypt;
import java.io.Serializable;

/**
 * This class represents the Accounts of all users including students and admins
 */
public class Account implements Serializable {
    /**
     * This is the username of the account
     */
    private String username;
    /**
     * This is the password of the account
     */
    private String password;
    /**
     * This is the domain of the account, can be student or admin
     */
    private String accountType;

    /**
     * Creates an account using username, password, accountType
     * @param username
     * @param password
     * @param accountType
     */
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

    /**
     * Checks the username and password is valid
     * @param username
     * @param password
     * @return
     */
    public boolean validate(String username, String password){

        if (!(username.equals(this.username)))
            return false;
        else if (!encrypt.check(password,this.password))
            return false;
        else
            return true;
    }

    /**
     * Get username
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * Get password
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Get accountType, either student or admin
     * @return
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * Changes username of an account
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Changes the password of an account
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Changes the accountType of an account
     * @param accountType
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
