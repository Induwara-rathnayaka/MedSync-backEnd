package com.medsync.Medsync_booking.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medsync.Medsync_booking.Model.Booking;
import com.medsync.Medsync_booking.Repository.BookingRepository;


@Service
public class BookingService {
    @Autowired
    BookingRepository Repo;

    public Booking creatBooking(Booking booking){
        return Repo.save(booking);
    }

    public Booking getBookingById(String id){
        Optional<Booking> booking = Repo.findById(id); 
        return booking.orElse(null);
    }

    public  List<Booking> getAllBooking(){
        return Repo.findAll();
    }

    public Booking updateBooking(String id , Booking booking){
        if (Repo.existsById(id)) {
            booking.setId(id);
            return Repo.save(booking);
        }
        return null;
    }

    public String deleteBooking(String id){
        if (Repo.existsById(id)) {
            Repo.deleteById(id);
            return "Delete Suscessfull";
        }
        return "Booking not found";
    }
}
