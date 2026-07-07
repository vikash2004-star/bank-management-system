package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import model.Account;

public class FileUtil {

    private static final String FILE_NAME = "accounts.dat";

    public static void saveAccounts(HashMap<String, Account> accounts) {

        try {

            ObjectOutputStream oos =
                    new ObjectOutputStream(new FileOutputStream(FILE_NAME));

            oos.writeObject(accounts);

            oos.close();

            System.out.println("Accounts Saved Successfully.");

        } catch (Exception e) {

            System.out.println("Error Saving Accounts.");

        }

    }

    @SuppressWarnings("unchecked")
    public static HashMap<String, Account> loadAccounts() {

        try {

            ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream(FILE_NAME));

            HashMap<String, Account> accounts =
                    (HashMap<String, Account>) ois.readObject();

            ois.close();

            return accounts;

        } catch (Exception e) {

            return new HashMap<>();

        }

    }

}