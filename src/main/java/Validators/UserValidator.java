package Validators;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Validator for the User model
 * @author Michael
 */
public class UserValidator {
        
        public static boolean login(String username, String password) {
            try {
                return MariaDB.loginQuery(username, encrypt(password));
            }   // end of try
            catch(Exception e) { 
                System.out.println("OOPSIES");
            }   // end of catch
            return false;
        }
        
        private static String encrypt(String password) throws NoSuchAlgorithmException{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());

            byte byteData[] = md.digest();

            //convert the byte to hex format method 1
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
             sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }

            return sb.toString();
        }
           
} // UserValidator.java