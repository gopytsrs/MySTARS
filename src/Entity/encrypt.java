package Entity;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import org.apache.commons.codec.binary.Base64;

public class encrypt {
    /**
     * Fixed number of iterations
     */
    private static final int iterations = 20*1000;
    /**
     * number of random bytes for salt len
     */
    private static final int saltLen = 32;
    /**
     * desired key length
     */
    private static final int desiredKeyLen = 256;


    /**
     * method which pulls in password for hashing
     * @param password
     * @return
     */
    public static String getSaltedHash(String password){
        try {
            byte[] salt = SecureRandom.getInstance("SHA1PRNG").generateSeed(saltLen);
            // store the salt with the password
            return Base64.encodeBase64String(salt) + "$" + hash(password, salt);
        }catch(Exception E){System.out.println("Error in hashing");return"fail";}
    }

    /**
     * This method checks the password
     * @param password
     * @param stored
     * @return
     */
    public static boolean check(String password, String stored){
        String[] saltAndHash = stored.split("\\$");
        if (saltAndHash.length != 2) {
            System.out.println(
                    "The stored password must have the form 'salt$hash'");
        }
        String hashOfInput = hash(password, Base64.decodeBase64(saltAndHash[0]));
        return hashOfInput.equals(saltAndHash[1]);
    }

    /**
     * This method hashes the password
     * @param password
     * @param salt
     * @return
     */
    private static String hash(String password, byte[] salt) {
        try{
            if (password == null || password.length() == 0)
                throw new IllegalArgumentException("Empty passwords are not supported.");
            SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            SecretKey key = f.generateSecret(new PBEKeySpec(
                    password.toCharArray(), salt, iterations, desiredKeyLen));
            return Base64.encodeBase64String(key.getEncoded());
        }catch (Exception E){System.out.println("Error in hashing"); return"fail";}

    }
}

//used from https://stackoverflow.com/questions/2860943/how-can-i-hash-a-password-in-java