package com.medsync.Medsync_booking.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medsync.Medsync_booking.Model.Patient;
import com.medsync.Medsync_booking.Repository.PatientRepositery;

@Service
public class PatientService {

    @Autowired
    PatientRepositery Repo;

    public Patient creatPatient(Patient patient){
        return Repo.save(patient);
    }

    public Patient getPatientById(String id){
        Optional<Patient> patient = Repo.findById(id); 
        return patient.orElse(null);
    }

    public  List<Patient> getAllPatient(){
        return Repo.findAll();
    }

    public Patient updatePatient(String id , Patient patient){
        if (Repo.existsById(id)) {
            patient.setId(id);
            return Repo.save(patient);
        }
        return null;
    }

    public String deletePatient(String id){
        if (Repo.existsById(id)) {
            Repo.deleteById(id);
            return "Delete Suscessfull";
        }
        return "Patient not found";
    }
}