package com.medsync.Medsync_booking.Controller;

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
public class BookingController {
    @Autowired
    BookingService bookingService;

    @PostMapping({"/create"})
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        Booking createBooking = bookingService.creatBooking(booking);
        return ResponseEntity.ok(createBooking);
    }
    
    @GetMapping({"/getById/{id}"})
    public ResponseEntity<Booking> getBookingByID(@PathVariable String id) {
        Booking getBooking = bookingService.getBookingById(id);
        return getBooking != null 
        ? ResponseEntity.ok(getBooking) 
        : ResponseEntity.notFound().build();
    }

    @GetMapping({"/getAll"})
    public ResponseEntity<List<Booking>> getAllBooking() {
        List<Booking> booking = bookingService.getAllBooking();
        return ResponseEntity.ok(booking);
    }

    @PutMapping({"/update/{id}"})
    public ResponseEntity<Booking> updateBooking(@PathVariable String id, @RequestBody Booking booking) {
        Booking upBooking = bookingService.updateBooking(id, booking);        
        return upBooking != null 
        ? ResponseEntity.ok(upBooking) 
        : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable String id) {
        String result = bookingService.deleteBooking(id);
        return result != null 
        ? ResponseEntity.ok(result) 
        : ResponseEntity.notFound().build();
    }
}
