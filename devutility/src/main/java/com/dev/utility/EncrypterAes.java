package com.dev.utility;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;

public class EncrypterAes {

	Cipher ecipher;
	Cipher dcipher;

	private static final String PASSPHRASE = "In the middle of difficulty lies opportunity";
	private static final int DEFAULT_KEY_LENGTH = 256;
	private static final int DEFAULT_ITERATION_COUNT = 65536;
	private static final String DEFAULT_ENCRPYT_ALGO = "AES/GCM/NoPadding";
	private static final String DEFAULT_KEY_ALGO = "PBKDF2WithHmacSHA256";
	private static final byte[] DEFAULT_SALT = { (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32, (byte) 0x56, (byte) 0x34, (byte) 0xE3,(byte) 0x03 };
	private static final int AUTH_TAG_LENGTH = 128;
	//private static final String DEFAULT_PASS_PHRASE = "In the middle of difficulty lies opportunity";

	public EncrypterAes(String passPhrase, int keyLength, int iterationCount,byte[] salt,boolean randomIv,String Algo,String encryptAlgo) {
		try {
			passPhrase=(passPhrase==null||passPhrase.isBlank())?PASSPHRASE:passPhrase;
			encryptAlgo=(encryptAlgo==null||encryptAlgo.isBlank())?DEFAULT_ENCRPYT_ALGO:encryptAlgo;
			keyLength=(keyLength==0)?DEFAULT_KEY_LENGTH:keyLength;
			iterationCount=(iterationCount==0)?DEFAULT_ITERATION_COUNT:iterationCount;
			salt =!(salt==null || salt.length==0)?salt:DEFAULT_SALT;
			Algo=(Algo==null||Algo.isEmpty())?DEFAULT_KEY_ALGO:Algo;
			SecretKeyFactory factory = SecretKeyFactory.getInstance(Algo);
			KeySpec spec = new PBEKeySpec(passPhrase.toCharArray(), salt, iterationCount, keyLength);
			SecretKey tmp = factory.generateSecret(spec);
			SecretKey key = new SecretKeySpec(tmp.getEncoded(), "AES");
			// Generating IV.
			byte[] IV = new byte[16];
			if(randomIv)
				new SecureRandom().nextBytes(IV);

			// Create SecretKeySpec
			SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "AES");

			// Create GCMParameterSpec
			GCMParameterSpec parameterSpec = new GCMParameterSpec(AUTH_TAG_LENGTH, IV);

			// Create an instance of cipher
			ecipher = Cipher.getInstance(encryptAlgo);
			dcipher = Cipher.getInstance(encryptAlgo);

			// Initialize the cipher with the key and IV
			ecipher.init(Cipher.ENCRYPT_MODE, keySpec, parameterSpec);
			dcipher.init(Cipher.DECRYPT_MODE, keySpec, parameterSpec);

		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}	}
	public String encrypt(String str) {
		if (str != null && str.length() > 0) {
			try {
				// Encode the string into bytes using utf-8
				byte[] utf8 = str.getBytes("UTF8");

				// Encrypt
				byte[] enc = ecipher.doFinal(utf8);

				// Encode bytes to base64 to get a string
				Base64.Encoder encoder = Base64.getEncoder();
				return encoder.encodeToString(enc);

			} catch (BadPaddingException e) {
				e.printStackTrace();
			} catch (IllegalBlockSizeException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * Takes a encrypted String as an argument, decrypts and returns the decrypted
	 * String.
	 * 
	 * @param str Encrypted String to be decrypted
	 * @return <code>String</code> Decrypted version of the provided String
	 */
	public String decrypt(String str) {

		if (str != null && str.length() > 0) {
			try {

				Base64.Decoder decoder = Base64.getDecoder();
				// Decode base64 to get bytes
				byte[] dec = decoder.decode(str);

				// Decrypt
				byte[] utf8 = dcipher.doFinal(dec);

				// Decode using utf-8
				return new String(utf8, "UTF8");

			} catch (BadPaddingException e) {

			} catch (IllegalBlockSizeException e) {
			} catch (UnsupportedEncodingException e) {
			} catch (Exception e) {
			}
		}
		return null;
		
	}
}

