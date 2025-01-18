package com.medsync.Medsync_booking.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.medsync.Medsync_booking.Model.Patient;

public interface PatientRepositery extends MongoRepository<Patient,String> {

    Patient findByEmail(String email);

}
