package com.medsync.Medsync_booking.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.medsync.Medsync_booking.Model.Doctor;
import com.medsync.Medsync_booking.Repository.DoctorRepository;

@Service
public class DoctorService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    DoctorRepository Repo;

    public String creatDocter(Doctor docter){
        if (Repo.existsById(docter.getDoctorID())) {
            return "Alredy docter in this ID";
            
        }else{
            Doctor newAdd = docter;
            newAdd.setPassword(passwordEncoder.encode(newAdd.getPassword()));
            Repo.save(newAdd);
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
            docter.setDoctorID(id);
            Doctor newAdd = docter;
            newAdd.setPassword(passwordEncoder.encode(newAdd.getPassword()));
            Repo.save(newAdd);
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

    public String loging(String doctorID , String password){

        if (Repo.existsById(doctorID)) {

            Optional<Doctor> check = Repo.findById(doctorID);

            String pas = check.get().getPassword();

            if(passwordEncoder.matches(password, pas)){

                return "Login Sucsessfull";

            }  else{

                return "Password Doesn't match";
            }
        }

        else{

            return "Doctor not found";
            
        }
    }

}
