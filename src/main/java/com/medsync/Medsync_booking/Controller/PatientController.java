package com.medsync.Medsync_booking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medsync.Medsync_booking.Model.Patient;
import com.medsync.Medsync_booking.Service.PatientService;

import jakarta.validation.Valid;


@RestController
@Validated
@RequestMapping("patient")
public class PatientController {
    
    @Autowired
    PatientService patientService;

    @PostMapping({"/create"})
    public ResponseEntity<String> createPatient(@RequestBody @Valid Patient patient) {
        String createPatient = patientService.creatPatient(patient);
        return ResponseEntity.ok(createPatient);
    }
    
    @GetMapping({"/getById/{id}"})
    public ResponseEntity<Patient> getPatientByID(@PathVariable String id) {
        Patient getPatient = patientService.getPatientById(id);
        return getPatient != null 
        ? ResponseEntity.ok(getPatient) 
        : ResponseEntity.notFound().build();
    }

    @GetMapping({"/getAll"})
    public ResponseEntity<List<Patient>> getAllPatient() {
        List<Patient> patients = patientService.getAllPatient();
        return ResponseEntity.ok(patients);
    }

    @PutMapping({"/upload/{id}"})
    public ResponseEntity<Patient> updatePatient(@PathVariable String id, @RequestBody Patient patient) {
        Patient upPatienn = patientService.updatePatient(id, patient);        
        return upPatienn != null 
        ? ResponseEntity.ok(upPatienn) 
        : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable String id) {
        String result = patientService.deletePatient(id);
        return result != null 
        ? ResponseEntity.ok(result) 
        : ResponseEntity.notFound().build();
    }

    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<Patient> getByEmail(@PathVariable String email){
        Patient patient = patientService.FindByEmail(email);
        return patient != null 
        ? ResponseEntity.ok(patient) 
        : ResponseEntity.notFound().build();
    }

    @PostMapping("/loging/{email}/{password}")
    public ResponseEntity<String> patientLoging(@PathVariable String email , String password){
        String status = patientService.loging(email, password);
        return ResponseEntity.ok(status);
    }
 }
