package com.medsync.Medsync_booking.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.medsync.Medsync_booking.Model.Shedule;
import java.util.List;


public interface SheduleRepository extends MongoRepository<Shedule , String> {
    
    List<Shedule> findByDocterID(String docterID);
    
}
