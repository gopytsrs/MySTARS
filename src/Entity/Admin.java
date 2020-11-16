package Entity;

import java.io.Serializable;

public class Admin implements Serializable {
    private int adminID;
    private Account account;

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
