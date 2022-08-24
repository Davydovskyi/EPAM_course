package by.jonline.module_6.home_library.service.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import by.jonline.module_6.home_library.service.ServiceException;

public class PasswordHashing {

	private static final String ALGORITHM = "PBKDF2WithHmacSHA512";
	private static final SecureRandom RANDOM = new SecureRandom();
	private static final int SIZE = 128;
	private static final int ITERATIONS = 65536;

	private PasswordHashing() {
	}

	public static String generateSalt() {
		byte[] salt = new byte[SIZE / 8];
		RANDOM.nextBytes(salt);

		return Base64.getEncoder().encodeToString(salt);
	}

	public static String hashPassword(String password, String salt) throws ServiceException {
		char[] chars = password.toCharArray();
		byte[] bytes = salt.getBytes();
		byte[] securePassword;

		PBEKeySpec spec = new PBEKeySpec(chars, bytes, ITERATIONS, SIZE);
		try {
			SecretKeyFactory fac = SecretKeyFactory.getInstance(ALGORITHM);
			securePassword = fac.generateSecret(spec).getEncoded();
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new ServiceException("Exception encountered in hashPassword()", e);
		}
		return Base64.getEncoder().encodeToString(securePassword);
	}

	public static boolean verifyPassword(String password, String key, String salt) throws ServiceException {
		String hashedPassword;
		hashedPassword = hashPassword(password, salt);
		if (hashedPassword == null || hashedPassword.isEmpty()) {
			return false;
		}
		return hashedPassword.equals(key);
	}
}