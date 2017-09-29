package Validators;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Validator for the User model
 * @author Michael
 */
public class UserValidator {
        
        public static boolean register(String username, String password) {
            return MariaDB.registerQuery(username, encrypt(password));
        }
    
        public static boolean login(String username, String password) {
            return MariaDB.loginQuery(username, encrypt(password));
        }
        
        private static String encrypt(String password) {
            String salted = "Malachowsky" + password;
            StringBuilder hash = new StringBuilder();
            try {
                // MessageDigest format MD5. Other options are SHA-1 or SHA-256
                MessageDigest mdfive = MessageDigest.getInstance("MD5");
                // performs a final update on the digest using the specified array of bytes
                // then completes the digest computation
                byte[] hashedBytes = mdfive.digest(salted.getBytes());
                // hexadecimal digits
                char[] digits = {'0', '1', '2', '3', '4', '5', '6',
                    '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
                // populate StringBuilder using Bitwise and  Bit Shift operators
                for (int i = 0; i < hashedBytes.length; i++) {
                    byte b = hashedBytes[i];
                    hash.append(digits[(b & 0xf0) >> 4]);
                    hash.append(digits[b & 0x0f]);
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            // Convert StringBuilder to string (32 character hashcode)
            return hash.toString();
        }
        
} // UserValidator.java