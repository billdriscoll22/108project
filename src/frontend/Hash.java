package frontend;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
	
	// compares a password against a hash value
	// returns true if they match and false otherwise
	public static boolean checkPassword(String password, String hash){
		String passHash = getHash(password);
		return hash.equals(passHash);
	}
	
	// takes a password string and returns the corresponding
	// hash value
	public static String getHash(String password){
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException e) {e.printStackTrace();}
		byte[] byteForm = password.getBytes();
		byte[] hash = md.digest(byteForm);
		
		return hexToString(hash);
		
	}
	
	
	/*
	 Given a byte[] array, produces a hex String,
	 such as "234a6f". with 2 chars for each byte in the array.
	 (provided code)
	*/
	public static String hexToString(byte[] bytes) {
		StringBuffer buff = new StringBuffer();
		for (int i=0; i<bytes.length; i++) {
			int val = bytes[i];
			val = val & 0xff;  // remove higher bits, sign
			if (val<16) buff.append('0'); // leading 0
			buff.append(Integer.toString(val, 16));
		}
		return buff.toString();
	}
	
	/*
	 Given a string of hex byte values such as "24a26f", creates
	 a byte[] array of those values, one byte value -128..127
	 for each 2 chars.
	 (provided code)
	*/
	public static byte[] hexToArray(String hex) {
		byte[] result = new byte[hex.length()/2];
		for (int i=0; i<hex.length(); i+=2) {
			result[i/2] = (byte) Integer.parseInt(hex.substring(i, i+2), 16);
		}
		return result;
	}

}
