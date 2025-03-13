package com.medsync.Medsync_booking.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.medsync.Medsync_booking.Model.Patient;
import com.medsync.Medsync_booking.Repository.PatientRepositery;

@Service
public class PatientService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    PatientRepositery Repo;

    public String creatPatient(Patient patient){

        Optional<Patient> searchPatient = Repo.findByEmail(patient.getEmail());

        //save user unique email 
        if(searchPatient.isPresent()){
           return "Alredy use this email";
        }else{
            Patient newAdd = patient;
            newAdd.setPassword(passwordEncoder.encode(newAdd.getPassword()));
            Repo.save(newAdd);
            return "Registration sucsessfull";
        }  
    }

    public Patient getPatientById(String id){
        Optional<Patient> patient = Repo.findById(id); 
        return patient.orElse(null);
    }

    public  List<Patient> getAllPatient(){
        return Repo.findAll();
    }

    public String updatePatient(String email , Patient patient){

        Optional<Patient> searchPa = Repo.findByEmail(email);

        if (searchPa.isPresent()) {
            Patient newAdd = patient;
            newAdd.setId(searchPa.get().getId());
            newAdd.setEmail(searchPa.get().getEmail());
            newAdd.setPassword(passwordEncoder.encode(newAdd.getPassword()));
            Repo.save(newAdd);
            return "Paitient Updated";
        }
        return "Not Paitient in this Email";
    }

    public String deletePatient(String id){
        if (Repo.existsById(id)) {
            Repo.deleteById(id);
            return "Delete Suscessfull";
        }
        return "Patient not found";
    }

    public Patient FindByEmail(String email) {
        Optional<Patient> patient = Repo.findByEmail(email);
        return patient.orElse(null);
    }

    public String loging(String email, String password){


        if (Repo.findByEmail(email).isPresent()) {

            Optional<Patient> check = Repo.findByEmail(email);

            String pas = check.get().getPassword();

            if(passwordEncoder.matches(password, pas)){

                return "Login Sucsessfull";

            }  else{

                return "Password Doesn't match";
            }
        }

        else{

            return "Not paitient in this Email";
            
        }
    }
}