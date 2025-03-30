package com.dev.utility.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*")  
@RestController
public class keyStoreController {
	
	@PostMapping("/decryptKeystore")
	public String decrypt(@RequestPart MultipartFile keystoreFile) {

		return null;
	}

}
