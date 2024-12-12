package com.medsync.Medsync_booking.Controller;

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
@RequestMapping({"api/shedule"})
public class SheduleController {

    @Autowired
    SheduleService sheduleService;

    @PostMapping()
    public ResponseEntity<Shedule> createDopcter(@RequestBody Shedule shedule) {
        Shedule createShedule = sheduleService.creatShedule(shedule);
        return ResponseEntity.ok(createShedule);
    }
    
    @GetMapping({"/{id}"})
    public ResponseEntity<Shedule> getDocterByID(@PathVariable String id) {
        Shedule getShedule = sheduleService.getSheduleById(id);
        return getShedule != null 
        ? ResponseEntity.ok(getShedule) 
        : ResponseEntity.notFound().build();
    }

    @GetMapping()
    public ResponseEntity<List<Shedule>> getMethodName() {
        List<Shedule> Sheduless = sheduleService.getAllShedule();
        return ResponseEntity.ok(Sheduless);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<Shedule> updateDocter(@PathVariable String id, @RequestBody Shedule shedule) {
        Shedule upShedule = sheduleService.updateShedule(id, shedule);        
        return upShedule != null 
        ? ResponseEntity.ok(upShedule) 
        : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDocter(@PathVariable String id) {
        String result = sheduleService.deleteShedule(id);
        return result != null 
        ? ResponseEntity.ok(result) 
        : ResponseEntity.notFound().build();
    }
}
