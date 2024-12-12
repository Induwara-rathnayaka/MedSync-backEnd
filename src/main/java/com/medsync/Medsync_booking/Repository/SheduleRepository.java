package com.medsync.Medsync_booking.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.medsync.Medsync_booking.Model.Shedule;

public interface SheduleRepository extends MongoRepository<Shedule , String> {

}
