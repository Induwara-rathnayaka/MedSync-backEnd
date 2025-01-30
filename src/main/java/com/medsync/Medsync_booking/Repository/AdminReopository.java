package com.medsync.Medsync_booking.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.medsync.Medsync_booking.Model.Admin;

public interface AdminReopository extends MongoRepository<Admin,String>{

        @Query("{ 'adminId' : ?0 , 'password' : ?1 }")
    Optional<Admin> findByEmailAndPassword(String adminId, String password);

}
