package com.robertp.testW5L1.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.robertp.testW5L1.models.Person;

@Repository
public interface UserRepository extends CrudRepository<Person, Long> {
    
    Optional<Person> findByEmail(String email);
    
}
