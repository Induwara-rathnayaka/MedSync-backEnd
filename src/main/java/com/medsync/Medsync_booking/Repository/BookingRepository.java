package com.medsync.Medsync_booking.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.medsync.Medsync_booking.Model.Booking;
import java.util.List;
import java.time.LocalDate;


public interface BookingRepository extends MongoRepository<Booking, String>{

    List<Booking> findByDoctorName(String doctorName);

    List<Booking> findByPatientEmail(String patientEmail);

    Booking findByPatientEmailAndDoctorNameAndDayAndTime(String patientEmail, String doctorName, LocalDate day, String time);

}