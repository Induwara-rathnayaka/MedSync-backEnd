package com.medsync.Medsync_booking.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.medsync.Medsync_booking.Model.DocterAdmin;

public interface DocterAdminRepository extends MongoRepository<DocterAdmin,String>{
    
}
