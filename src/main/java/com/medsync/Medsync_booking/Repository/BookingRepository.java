package com.medsync.Medsync_booking.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.medsync.Medsync_booking.Model.Booking;

public interface BookingRepository extends MongoRepository<Booking,String> {

}

