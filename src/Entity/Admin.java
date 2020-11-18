package Entity;

import java.io.Serializable;

public class Admin implements Serializable {
    private String adminName;
    private Account account;

    public Admin(String adminName) {
        setAdminName(adminName);
        this.account = new Account(this.adminName, "password1", "admin");
    }

    public String getAdminID() {
        return this.adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public Account getAccount() {
        return this.account;
    }

}
