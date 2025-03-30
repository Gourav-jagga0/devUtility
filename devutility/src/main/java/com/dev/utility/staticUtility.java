package com.dev.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;

public class staticUtility {
	static Set<String> passphrases = new HashSet();

	public static Set<String> getPassPhrases() {
		if (passphrases.isEmpty()) {
			passphrases = (HashSet<String>) loadFromFile("passPhrases");
		}
		return passphrases;
	}

	public static Set<String> setPassPhrases(String data) {
		if (passphrases.add(data)) {
			saveToFile("passPhrases", passphrases);
		}
		return passphrases;
	}

	public static void saveToFile(String fileName, Set data) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));) {
			out.writeObject(data);
		} catch (IOException e) {
			System.out.println("ERROR" + e);
		}
	}

	public static Object loadFromFile(String fileName) {
		Object data = null;
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));) {
			data = in.readObject();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("ERROR" + e);
		}
		return data;
	}
}
