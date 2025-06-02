package com.dev.utility.entities;

import java.util.Arrays;

public class Crypto {
	private String key;
	private String passPhrase;
	private int keyLength;
	private int iterationCount;
	private byte[] salt;
	private boolean randomIv;
	private String encryptAlgo;
	private String Algo;
	
	public Crypto() {
		super();
	}

	public Crypto(String key) {
		super();
		this.key = key;
	}

	public Crypto(String key, String passPhrase, int keyLength) {
		super();
		this.key = key;
		this.passPhrase = passPhrase;
		this.keyLength = keyLength;
	}

	public Crypto(String key, String passPhrase, int keyLength, int iterationCount, byte[] salt, boolean randomIv,
			String encryptAlgo, String algo) {
		super();
		this.key = key;
		this.passPhrase = passPhrase;
		this.keyLength = keyLength;
		this.iterationCount = iterationCount;
		this.salt = salt;
		this.randomIv = randomIv;
		this.encryptAlgo = encryptAlgo;
		Algo = algo;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getPassPhrase() {
		return passPhrase;
	}

	public void setPassPhrase(String passPhrase) {
		this.passPhrase = passPhrase;
	}

	public int getKeyLength() {
		return keyLength;
	}

	public void setKeyLength(int keyLength) {
		this.keyLength = keyLength;
	}

	public int getIterationCount() {
		return iterationCount;
	}

	public void setIterationCount(int iterationCount) {
		this.iterationCount = iterationCount;
	}

	public byte[] getSalt() {
		return salt;
	}

	public void setSalt(byte[] salt) {
		this.salt = salt;
	}

	public boolean isRandomIv() {
		return randomIv;
	}

	public void setRandomIv(boolean randomIv) {
		this.randomIv = randomIv;
	}

	public String getAlgo() {
		return Algo;
	}

	public void setAlgo(String algo) {
		Algo = algo;
	}

	public String getEncryptAlgo() {
		return encryptAlgo;
	}

	public void setEncryptAlgo(String encryptAlgo) {
		this.encryptAlgo = encryptAlgo;
	}

	@Override
	public String toString() {
		return "Crypto [key=" + key + ", passPhrase=" + passPhrase + ", keyLength=" + keyLength + ", iterationCount="
				+ iterationCount + ", salt=" + Arrays.toString(salt) + ", randomIv=" + randomIv + ", Algo=" + Algo
				+ "]";
	}

}
