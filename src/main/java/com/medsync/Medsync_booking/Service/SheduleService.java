package com.medsync.Medsync_booking.Service;

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
        Optional<Shedule> shOptional = Repo.findByDocterIDAndDayAndTime(shedule.getDocterID(),shedule.getDay(),shedule.getTime());
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
        return Repo.findByDocterID(docterID);
    }

    public Shedule getbyCustom(String docterID, String day, String time){
            Optional<Shedule> shedule = Repo.findByDocterIDAndDayAndTime(docterID,day,time);
            return shedule.orElse(null);
    }
}

