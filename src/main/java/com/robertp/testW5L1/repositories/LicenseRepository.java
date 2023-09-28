package com.robertp.testW5L1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.robertp.testW5L1.models.License;


@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {

	List<License> findAll();
	
}
