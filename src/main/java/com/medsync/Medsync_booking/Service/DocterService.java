package com.medsync.Medsync_booking.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medsync.Medsync_booking.Model.Docter;
import com.medsync.Medsync_booking.Repository.DocterRepository;

@Service
public class DocterService {
    @Autowired
    DocterRepository Repo;

    public String creatDocter(Docter docter){
        if (Repo.existsById(docter.getDocterID())) {
            return "Alredy docter in this ID";
            
        }else{
            Repo.save(docter);
            return "docter Registration sucsessfull";
        }
        
    }

    public Docter getDocterById(String id){
        Optional<Docter> docter = Repo.findById(id); 
        return docter.orElse(null);
    }

    public  List<Docter> getAllDocter(){
        return Repo.findAll();
    }

    public Docter updateDocter(String id , Docter docter){
        if (Repo.existsById(id)) {
            docter.setDocterID(id);
            return Repo.save(docter);
        }
        return null;
    }

    public String deleteDocter(String id){
        if (Repo.existsById(id)) {
            Repo.deleteById(id);
            return "Delete Suscessfull";
        }
        return "Docter not found";
    }

    public List<Docter> fingBySpecialty(String specialty){
        return Repo.findBySpecialty(specialty);
    }

    public String findByEmailAndPassword(String email , String password){
        Optional<Docter> searchDocter = Repo.findByEmailAndPassword(email,password);
        if (searchDocter.isPresent()) {
            return "Login Sucsessfull";
        }else{
            return "Docter not found";
        }
    }

}
