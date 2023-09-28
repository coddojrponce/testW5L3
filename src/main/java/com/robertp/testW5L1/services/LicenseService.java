package com.robertp.testW5L1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robertp.testW5L1.models.License;
import com.robertp.testW5L1.repositories.LicenseRepository;

@Service
public class LicenseService {
	
	@Autowired
	private LicenseRepository licenseRepo;

	//create
	
	public void create(License l) {
		licenseRepo.save(l);
	}
	
	//read
	
	
	
}
