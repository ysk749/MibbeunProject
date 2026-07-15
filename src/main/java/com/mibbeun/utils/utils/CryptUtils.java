package com.mibbeun.utils.utils;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.zip.Deflater;

public class CryptUtils {

	public final static String secretKey = "Key1234567890-1234567890-1234567";
	public final static String iv = "1234567890123456";    
    public final static int DEFAULT_BUFFER_SIZE = 256;
    
    public static byte[] getSecretKey() {
    	byte[] secretBinKey = null;
    	try {
    		//secretBinKey =  secretKey.getBytes("UTF-8");
    		secretBinKey =  secretKey.getBytes("UTF-8");
    		
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return secretBinKey;
    }

    public static byte[] getIv() {
    	byte[] secretBiniv = null;
    	try {
    		//secretBiniv =  iv.getBytes("UTF-8");
    		secretBiniv =  iv.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return secretBiniv;    	
    }

    public static String encrypt(String plaintext, String secretKey, String iv) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedText, String secretKey, String iv) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);

        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes);
    }
    
    public static byte[] encrypt(byte[] plaintext, byte[] secretKey, byte[] iv) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

        byte[] encryptedBytes = cipher.doFinal(plaintext);
        return Base64.getEncoder().encode(encryptedBytes);
    }

    public static byte[] decrypt(byte[] plaintext, byte[] secretKey, byte[] iv) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);

        byte[] encryptedBytes = Base64.getDecoder().decode(plaintext);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return decryptedBytes;
    }
    //AesCbcPkcs5
    public static String  GetAesCbcPkcs5Encrypt(byte[] plainText) throws Exception {
    	byte[] data = encrypt(plainText, getSecretKey(), getIv());
		return new String(data);
    }

    public static String  GetAesCbcPkcs5Decrypt(byte[] plainText) throws Exception {
		byte[] Bytedata = decrypt(plainText, getSecretKey(), getIv());
		return new String(Bytedata);
    }
}
