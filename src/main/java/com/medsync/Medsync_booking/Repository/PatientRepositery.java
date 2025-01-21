package com.medsync.Medsync_booking.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.medsync.Medsync_booking.Model.Patient;

public interface PatientRepositery extends MongoRepository<Patient,String> {

    Optional<Patient> findByEmail(String email);

    @Query("{ 'email' : ?0 , 'Password' : ?1 }")
    Optional<Patient> findByEmailAndPassword(String email, String Password);
    
}
