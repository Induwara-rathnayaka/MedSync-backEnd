package com.medsync.Medsync_booking.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medsync.Medsync_booking.Model.Shedule;
import com.medsync.Medsync_booking.Repository.SheduleRepository;

@Service
public class SheduleService {

    @Autowired
    SheduleRepository Repo;

    public Shedule creatShedule(Shedule shedule){
        Optional<Shedule> shOptional = Repo.findByDoctorIDAndDayAndTime(shedule.getDoctorID(),shedule.getDay(),shedule.getTime());
        if(shOptional.isPresent()){
            return null;
        }else{
            return Repo.save(shedule);
        }
    }

    public Shedule getSheduleById(String id){
        Optional<Shedule> docter = Repo.findById(id); 
        return docter.orElse(null);
    }

    public  List<Shedule> getAllShedule(){
        return Repo.findAll();
    }

    public Shedule updateShedule(String id , Shedule shedule){
        if (Repo.existsById(id)) {
            shedule.setID(id);
            return Repo.save(shedule);
        }
        return null;
    }

    public String deleteShedule(String id){
        if (Repo.existsById(id)) {
            Repo.deleteById(id);
            return "Delete Suscessfull";
        }
        return "Shedule not found";
    }

    public List<Shedule> getbyDocterID(String docterID){
        return Repo.findByDoctorName(docterID);
    }

    public Shedule getbyCustom(String doctorID, LocalDate day, String time){
            Optional<Shedule> shedule = Repo.findByDoctorIDAndDayAndTime(doctorID,day,time);
            return shedule.orElse(null);
    }

    public String request(String doctorID, LocalDate day, String time) {
        Optional<Shedule> optionalShedule = Repo.findByDoctorIDAndDayAndTime(doctorID, day, time);
    
        if (optionalShedule.isPresent()) {
            Shedule shedule = optionalShedule.get();
    
            if (shedule.getCount() > 0) {
                shedule.setCount(shedule.getCount() - 1); // Decrease count
                Repo.save(shedule); // Save the updated schedule
                return "Booking Successfull";
            } else {
                return "No available slots";
            }
        } else {
            return "Schedule not found";
        }
    }

    public String requestUp(String doctorID, LocalDate day, String time) {
        Optional<Shedule> optionalShedule = Repo.findByDoctorIDAndDayAndTime(doctorID, day, time);
    
        if (optionalShedule.isPresent()) {
            Shedule shedule = optionalShedule.get();
    
            if (shedule.getCount() < 10) {
                shedule.setCount(shedule.getCount() + 1); // Decrease count
                Repo.save(shedule); // Save the updated schedule
                return "Cancelled Successfull";
            } else {
                return "Maximum Schedule";
            }
        } else {
            return "Schedule not found";
        }
    }

    public String deleByDoctorId(String doctorID){
        Repo.deleteByDoctorID(doctorID);
        return "Delete Sucsessfull";
    }
}
    

