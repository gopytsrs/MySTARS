package Entity;

public class Account {
    private String username;
    private String password;
    private String accountType;
    public Account(String username, String password, String accountType){
        setUsername(username);
        setPassword(password);
        setAccountType(accountType);
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
