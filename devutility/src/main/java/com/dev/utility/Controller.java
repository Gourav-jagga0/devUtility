package com.dev.utility;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dev.utility.entities.Crypto;
@CrossOrigin(origins = "*")  
@RestController
public class Controller {

	@PostMapping("/decrypt")
	public String decrypt(@RequestBody Crypto data) {
		EncrypterAes desEncrypter = new EncrypterAes(data.getPassPhrase(), data.getKeyLength(),
				data.getIterationCount(), data.getSalt(), data.isRandomIv(), data.getAlgo(),data.getEncryptAlgo());
		staticUtility.setPassPhrases(data.getPassPhrase());
		String desEncrypted = desEncrypter.decrypt(data.getKey());
		return desEncrypted;
	}

	@PostMapping("/encrypt")
	public String encrypt(@RequestBody Crypto data) {
		EncrypterAes desEncrypter = new EncrypterAes(data.getPassPhrase(), data.getKeyLength(),
				data.getIterationCount(), data.getSalt(), data.isRandomIv(), data.getAlgo(),data.getEncryptAlgo());
		staticUtility.setPassPhrases(data.getPassPhrase());
		String desEncrypted = desEncrypter.encrypt(data.getKey());
		return desEncrypted;
	}

	@PostMapping("/decryptAll")
	public Map<String,String> decryptAll(@RequestBody Crypto data) {
		boolean decryption_found = false;
		//StringBuilder sb=new StringBuilder();
		Map<String,String> dto=new LinkedHashMap<String,String>();
		String decrypt_pass = null;
		for (int key :  new int[] {256,128,196}) {
			for (String pass : staticUtility.getPassPhrases()) {
				try {
					EncrypterAes desEncrypter1 = new  EncrypterAes(pass,key,
							data.getIterationCount(), data.getSalt(), data.isRandomIv(), data.getAlgo(),data.getEncryptAlgo());
					decrypt_pass = desEncrypter1.decrypt(data.getKey());
				} catch (Exception e) {
				}
				if (decrypt_pass != null) {
					decryption_found = true;
					dto.put("decrypted password",decrypt_pass);
					dto.put("passphrase",pass);
					dto.put("keylength",String.valueOf(key));
					return dto;
				}
			}
		}
		return dto;
	}

}
