package com.medsync.Medsync_booking.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.medsync.Medsync_booking.Model.Booking;
import java.util.List;
import java.time.LocalDate;


public interface BookingRepository extends MongoRepository<Booking, String>{

    List<Booking> findByDocterIdAndDayGreaterThanEqual(String docterId, LocalDate todayDate);

    List<Booking> findByPatientEmailAndDayGreaterThanEqual(String patientEmail , LocalDate todayDate);

    Booking findByPatientEmailAndDoctorNameAndDayAndTime(String patientEmail, String doctorName, LocalDate day, String time);

    void deleteByDocterId(String docterId);

}