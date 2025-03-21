package com.medsync.Medsync_booking.Service;

import java.time.LocalDate;
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

    public String createBooking(Booking booking){
        Booking Booked = Repo.findByPatientEmailAndDoctorNameAndDayAndTime(booking.getPatientEmail(),booking.getDoctorName(),booking.getDay(),booking.getTime());
        if (Booked == null) {
            Repo.save(booking);
            return "Booking Succsessfull";
            
        }else{
            return "Alredy Booked";
        }
    }

    public Booking getBookingById(String id){
        Optional<Booking> docter = Repo.findById(id); 
        return docter.orElse(null);
    }

    public  List<Booking> getAllBooking(){
        return Repo.findAll();
    }

    public Booking updateBooking(String id , Booking booking){
        if (Repo.existsById(id)) {
            booking.setId( id);
            return Repo.save(booking);
        }
        return null;
    }

    public String deleteBooking(String id){
        if (Repo.existsById(id)) {
            Repo.deleteById(id);
            return "Delete Suscessfull";
        }
        return "Shedule not found";
    }

    public List<Booking> getByDocterId(String docterId){
        LocalDate today = LocalDate.now();
        List<Booking> search = Repo.findByDocterIdAndDayGreaterThanEqual(docterId,today);
        return search;
    }

    public List<Booking> getByPatientEmail(String patientEmail){
        LocalDate today = LocalDate.now();
        List<Booking> search = Repo.findByPatientEmailAndDayGreaterThanEqual(patientEmail,today);
        return search;
    }

    public Booking delete(String patientEmail ,String doctorName , LocalDate day , String time){
            Booking book = Repo.findByPatientEmailAndDoctorNameAndDayAndTime(patientEmail, doctorName, day, time);
            Repo.deleteById(book.getId());
            return book;
    }

    public String deleByDoctorId(String doctorID){
        Repo.deleteByDocterId(doctorID);
        return "Delete Sucsessfull";
    }

    public String deletebyShedule(String docterId, LocalDate day, String time){
        Booking book = Repo.findByDocterIdAndDayAndTime(docterId, day, time);
        Repo.deleteById(book.getId());
        return "Delete Sucsessfull";
}

    
}
