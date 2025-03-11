package com.medsync.Medsync_booking.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medsync.Medsync_booking.Model.Booking;
import com.medsync.Medsync_booking.Service.BookingService;


@RestController
@RequestMapping({"Booking"})
public class BookingContraller {
    @Autowired
    BookingService bookingService;

    //create shedule
    @PostMapping({"/create"})
    public ResponseEntity<String> createShedule(@RequestBody Booking booking) {
        String createBooking = bookingService.createBooking(booking);
        return ResponseEntity.ok(createBooking);
    }
    
    //getshedule by id
    @GetMapping({"/getByID/{id}"})
    public ResponseEntity<Booking> getSheduleByID(@PathVariable String id) {
        Booking getBooking= bookingService.getBookingById(id);
        return getBooking!= null 
        ? ResponseEntity.ok(getBooking) 
        : ResponseEntity.notFound().build();
    }

    //get All shedules
    @GetMapping({"/getAll"})
    public ResponseEntity<List<Booking>> getAllShedule() {
        List<Booking> Bookingess = bookingService.getAllBooking();
        return ResponseEntity.ok(Bookingess);
    }

    //update shedule by id
    @PutMapping({"/update/{id}"})
    public ResponseEntity<Booking> updateShedule(@PathVariable String id, @RequestBody Booking booking) {
        Booking upBooking = bookingService.updateBooking(id, booking);        
        return upBooking != null 
        ? ResponseEntity.ok(upBooking) 
        : ResponseEntity.notFound().build();
    }

    //delete shedule by id
    @DeleteMapping({"/delete/{id}"})
    public ResponseEntity<String> deleteShedule(@PathVariable String id) {
        String result = bookingService.deleteBooking(id);
        return result != null 
        ? ResponseEntity.ok(result) 
        : ResponseEntity.notFound().build();
    }

    @GetMapping({"/getByDocterName/{doctorName}"})
    public ResponseEntity<List<Booking>> getByDocterName(@PathVariable String doctorName) {
        List<Booking> Bookingess = bookingService.getByDocterName(doctorName);
        return ResponseEntity.ok(Bookingess);        
    }

    @GetMapping({"/getByPAitentEmail/{patientEmail}"})
    public ResponseEntity<List<Booking>> getByPatientEmail(@PathVariable String patientEmail) {
        List<Booking> Bookingess = bookingService.getByPatientEmail(patientEmail);
        return ResponseEntity.ok(Bookingess);        
    }

    @DeleteMapping({"/deleteBooking/{patientEmail}/{doctorName}/{day}/{time}"})
    public ResponseEntity<Booking> delete(@PathVariable String patientEmail , @PathVariable String doctorName ,@PathVariable  LocalDate day ,@PathVariable String time) {
        Booking result = bookingService.delete(patientEmail, doctorName, day, time);
        return result != null 
        ? ResponseEntity.ok(result) 
        : ResponseEntity.notFound().build();
    }

}
