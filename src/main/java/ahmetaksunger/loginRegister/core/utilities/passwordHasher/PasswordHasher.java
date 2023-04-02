package ahmetaksunger.loginRegister.core.utilities.passwordHasher;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import jakarta.xml.bind.DatatypeConverter;

public class PasswordHasher {
    
	public static String hashPassword(String password) {
	    try {
	        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
	        byte[] hash = messageDigest.digest(password.getBytes(StandardCharsets.UTF_8));
	        return DatatypeConverter.printHexBinary(hash);
	    } catch (NoSuchAlgorithmException e) {
	        // handle the exception
	        e.printStackTrace();
	        return null;
	    }
	}
}

