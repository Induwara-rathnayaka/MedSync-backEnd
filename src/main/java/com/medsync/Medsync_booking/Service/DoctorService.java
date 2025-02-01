package com.medsync.Medsync_booking.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medsync.Medsync_booking.Model.Doctor;
import com.medsync.Medsync_booking.Repository.DoctorRepository;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository Repo;

    public String creatDocter(Doctor docter){
        if (Repo.existsById(docter.getDocterID())) {
            return "Alredy docter in this ID";
            
        }else{
            Repo.save(docter);
            return "docter Registration sucsessfull";
        }
        
    }

    public Doctor getDocterById(String id){
        Optional<Doctor> docter = Repo.findById(id); 
        return docter.orElse(null);
    }

    public  List<Doctor> getAllDocter(){
        return Repo.findAll();
    }

    public Doctor updateDocter(String id , Doctor docter){
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

    public List<Doctor> fingBySpecialty(String specialty){
        return Repo.findBySpecialty(specialty);
    }

    public String findByEmailAndPassword(String email , String password){
        Optional<Doctor> searchDocter = Repo.findByEmailAndPassword(email,password);
        if (searchDocter.isPresent()) {
            return "Login Sucsessfull";
        }else{
            return "Docter not found";
        }
    }

}
