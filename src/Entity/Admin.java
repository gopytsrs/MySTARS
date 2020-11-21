package Entity;

import java.io.Serializable;

/**
 * This is the class represents the Admins
 */
public class Admin implements Serializable {
    /**
     * This is the name of an admin
     */
    private String adminName;
    /**
     * This is the account of an admin
     */
    private Account account;

    /**
     * Creates an admin with a name
     * @param adminName
     */
    public Admin(String adminName) {
        setAdminName(adminName);
        this.account = new Account(this.adminName,"password1", "admin");
    }

    /**
     * Get Admin name
     * @return
     */
    public String getAdminName() {
        return this.adminName;
    }

    /**
     * Change the admin name
     * @param adminName
     */
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    /**
     * Get admin account
     * @return
     */
    public Account getAccount() {
        return this.account;
    }

}
