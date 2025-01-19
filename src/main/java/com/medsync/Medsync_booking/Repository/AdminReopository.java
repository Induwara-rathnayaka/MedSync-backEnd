package com.medsync.Medsync_booking.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.medsync.Medsync_booking.Model.Admin;

public interface AdminReopository extends MongoRepository<Admin,String>{

}
