package com.medsync.Medsync_booking.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.medsync.Medsync_booking.Model.Doctor;

import java.util.List;
import java.util.Optional;



public interface DoctorRepository extends MongoRepository<Doctor,String>{  
    
    List<Doctor> findBySpecialty(String specialty);
    
    @Query("{ 'email' : ?0 , 'password' : ?1 }")
    Optional<Doctor> findByEmailAndPassword(String email, String password);
    

}
