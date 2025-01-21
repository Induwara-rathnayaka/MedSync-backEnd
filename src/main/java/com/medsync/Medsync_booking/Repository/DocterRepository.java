package com.medsync.Medsync_booking.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.medsync.Medsync_booking.Model.Docter;
import java.util.List;
import java.util.Optional;



public interface DocterRepository extends MongoRepository<Docter,String>{  
    
    List<Docter> findBySpecialty(String specialty);
    
    @Query("{ 'email' : ?0 , 'password' : ?1 }")
    Optional<Docter> findByEmailAndPassword(String email, String password);
    

}
