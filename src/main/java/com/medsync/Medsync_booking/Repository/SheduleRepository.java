package com.medsync.Medsync_booking.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.medsync.Medsync_booking.Model.Shedule;
import java.util.List;
import java.util.Optional;



public interface SheduleRepository extends MongoRepository<Shedule , String> {
    
    List<Shedule> findByDoctorID(String doctorID);

    @Query("{ 'doctorID' : ?0 , 'day' : ?1 , 'time' : ?2 }")
    Optional<Shedule>  findByDoctorIDAndDayAndTime(String doctorID, String day, String time);

}
