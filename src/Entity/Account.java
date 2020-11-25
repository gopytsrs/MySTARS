package Entity;

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
     *
     * @param username    The username of the account
     * @param password    The password of the account
     * @param accountType The account type which can be student or admin
     */
    public Account(String username, String password, String accountType) {
        setUsername(username);
        try {
            String hashed = Encrypt.getSaltedHash(password);
            setPassword(hashed);
        } catch (Exception E) {
            System.out.println("password setting error");
            return;
        }
        setAccountType(accountType);
    }

    /**
     * Checks the username and password is valid
     *
     * @param username The username you enter
     * @param password The password you enter
     * @return
     */
    public boolean validate(String username, String password) {

        if (!(username.equals(this.username)))
            return false;
        else if (!Encrypt.check(password, this.password))
            return false;
        else
            return true;
    }

    /**
     * Get username
     *
     * @return The username of account
     */
    public String getUsername() {
        return username;
    }

    /**
     * Get password
     *
     * @return The password of account
     */
    public String getPassword() {
        return password;
    }

    /**
     * Get accountType, either student or admin
     *
     * @return The account type of this account
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * Changes username of an account
     *
     * @param username The username of account
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Changes the password of an account
     *
     * @param password The password of this account
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Changes the accountType of an account
     *
     * @param accountType The account type of this account
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
