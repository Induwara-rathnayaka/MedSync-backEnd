package com.medsync.Medsync_booking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medsync.Medsync_booking.Model.Doctor;
import com.medsync.Medsync_booking.Service.DoctorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.validation.Valid;



@RestController
@Validated
@RequestMapping({"Doctor"})
public class DoctorController {

    @Autowired
    DoctorService docterService;

    //create doctor
    @PostMapping({"/create"})
    public ResponseEntity<String> createDopcter(@RequestBody @Valid Doctor docter) {
        String createdocter = docterService.creatDocter(docter);
        return ResponseEntity.ok(createdocter);
    }
    
    //get doctor by doctor id
    @GetMapping({"/getById/{id}"})
    public ResponseEntity<Doctor> getDocterByID(@PathVariable String id) {
        Doctor getDocter = docterService.getDocterById(id);
        return getDocter != null 
        ? ResponseEntity.ok(getDocter) 
        : ResponseEntity.notFound().build();
    }

    //get All register Doctors
    @GetMapping({"/getAll"})
    public ResponseEntity<List<Doctor>> getAllDocter() {
        List<Doctor> docters = docterService.getAllDocter();
        return ResponseEntity.ok(docters);
    }

    @PutMapping({"/update/{id}"})
    public ResponseEntity<Doctor> updateDocter(@PathVariable String id, @RequestBody Doctor docter) {
        Doctor upDocter = docterService.updateDocter(id, docter);        
        return upDocter != null 
        ? ResponseEntity.ok(upDocter) 
        : ResponseEntity.notFound().build();
    }

    //delete doctor by doctor id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDocter(@PathVariable String id) {
        String result = docterService.deleteDocter(id);
        return result != null 
        ? ResponseEntity.ok(result) 
        : ResponseEntity.notFound().build();
    }

    //get Doctors by their specility
    @GetMapping("/getByspecialty/{specialty}")
    public ResponseEntity<List<Doctor>> getDocterBySpecialty(@PathVariable String specialty){
        List<Doctor> docters = docterService.fingBySpecialty(specialty);
        return ResponseEntity.ok(docters);
    }

    //docter Loging (return string )
    @PostMapping("/Login/{doctorID}/{password}")
    public ResponseEntity<String> searchDocters(@PathVariable String doctorID, @PathVariable String password){
        String docters = docterService.loging(doctorID, password);
        return ResponseEntity.ok(docters);
    }
    
}
