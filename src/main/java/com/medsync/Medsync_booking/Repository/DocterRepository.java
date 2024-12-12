package com.medsync.Medsync_booking.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.medsync.Medsync_booking.Model.Docter;

public interface DocterRepository extends MongoRepository<Docter,String>{    

}
