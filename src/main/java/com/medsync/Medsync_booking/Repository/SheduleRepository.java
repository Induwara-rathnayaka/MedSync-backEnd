package com.medsync.Medsync_booking.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.medsync.Medsync_booking.Model.Shedule;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;



public interface SheduleRepository extends MongoRepository<Shedule , String> {
    
    List<Shedule> findByDocterID(String docterID);

    @Query("{ 'docterID' : ?0 , 'day' : ?1 , 'time' : ?2 }")
    Optional<Shedule> findByDocterIDAndDayAndTime(String docterID, LocalDate day, String time);

}
