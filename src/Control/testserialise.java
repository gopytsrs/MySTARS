package Control;


import Entity.Account;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class testserialise {
    public static void main(String[] args) {
        Account a = new Account("test", "password", "student");
        String fileName = "testAccountData.bin";
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream os = new ObjectOutputStream(fileOut);
            os.writeObject(a);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
