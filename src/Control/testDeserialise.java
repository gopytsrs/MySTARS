package Control;

import Entity.Account;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class testDeserialise {
    public static void main(String[] args) {
        Account demoAccount;
        try {
            FileInputStream file = new FileInputStream("testAccountData.bin");
            ObjectInputStream in = new ObjectInputStream(file);
            demoAccount = (Account) in.readObject();
            System.out.println(demoAccount.getUsername());
            System.out.println(demoAccount.getAccountType());
            System.out.println(demoAccount.getPassword());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
