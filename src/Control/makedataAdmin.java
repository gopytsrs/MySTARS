package Control;

import Entity.Admin;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MakeDataAdmin {
    public static void main(String args[]) throws Exception {
        ArrayList<Admin> A = new ArrayList<>();
        Admin ad = new Admin("admin");
        A.add(ad);
        String fileName = "database_admin.bin";
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream os = new ObjectOutputStream(fileOut);
            os.writeObject(A);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
