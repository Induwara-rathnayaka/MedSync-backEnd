package com.medsync.Medsync_booking.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medsync.Medsync_booking.Model.Shedule;
import com.medsync.Medsync_booking.Service.SheduleService;

@RestController
@RequestMapping({"shedule"})
public class SheduleController {

    @Autowired
    SheduleService sheduleService;

    //create shedule
    @PostMapping({"/create"})
    public ResponseEntity<Shedule> createShedule(@RequestBody Shedule shedule) {
        Shedule createShedule = sheduleService.creatShedule(shedule);
        return ResponseEntity.ok(createShedule);
    }
    
    //getshedule by id
    @GetMapping({"/getByID/{id}"})
    public ResponseEntity<Shedule> getSheduleByID(@PathVariable String id) {
        Shedule getShedule = sheduleService.getSheduleById(id);
        return getShedule != null 
        ? ResponseEntity.ok(getShedule) 
        : ResponseEntity.notFound().build();
    }

    //get All shedules
    @GetMapping({"/getAll"})
    public ResponseEntity<List<Shedule>> getAllShedule() {
        List<Shedule> Sheduless = sheduleService.getAllShedule();
        return ResponseEntity.ok(Sheduless);
    }

    //update shedule by id
    @PutMapping({"/update/{id}"})
    public ResponseEntity<Shedule> updateShedule(@PathVariable String id, @RequestBody Shedule shedule) {
        Shedule upShedule = sheduleService.updateShedule(id, shedule);        
        return upShedule != null 
        ? ResponseEntity.ok(upShedule) 
        : ResponseEntity.notFound().build();
    }

    //delete shedule by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteShedule(@PathVariable String id) {
        String result = sheduleService.deleteShedule(id);
        return result != null 
        ? ResponseEntity.ok(result) 
        : ResponseEntity.notFound().build();
    }

    //get shedule by docter iD
    @GetMapping("/getByDoctorName/{doctorName}")
    public ResponseEntity<List<Shedule>> getSheduleByDoctrerID(@PathVariable String doctorName){
        List<Shedule> shedules = sheduleService.getbyDocterID(doctorName);
        return ResponseEntity.ok(shedules);
    }

    //get shedule by docter id  , day and time
    @GetMapping("/getByCustom/{doctorID}/{day}/{time}")
    public ResponseEntity<Shedule> getSheduleByCustom(@PathVariable String doctorID , @PathVariable LocalDate day , @PathVariable String time ){
        Shedule result = sheduleService.getbyCustom(doctorID,day,time);
        return result != null 
        ? ResponseEntity.ok(result) 
        : ResponseEntity.notFound().build();
    }

    @PutMapping("/updateShedule/{doctorID}/{day}/{time}")
    public ResponseEntity<String> updateshedule(@PathVariable String doctorID , @PathVariable LocalDate day , @PathVariable String time ){
        String result = sheduleService.request(doctorID,day,time);
        return result != null 
        ? ResponseEntity.ok(result) 
        : ResponseEntity.notFound().build();
    }
}
