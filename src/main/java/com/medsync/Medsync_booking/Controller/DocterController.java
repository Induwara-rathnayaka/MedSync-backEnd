package com.medsync.Medsync_booking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medsync.Medsync_booking.Model.Docter;
import com.medsync.Medsync_booking.Service.DocterService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping({"api/Docter"})
public class DocterController {

    @Autowired
    DocterService docterService;

    @PostMapping()
    public ResponseEntity<Docter> createDopcter(@RequestBody Docter docter) {
        Docter createdocter = docterService.creatDocter(docter);
        return ResponseEntity.ok(createdocter);
    }
    
    @GetMapping({"/{id}"})
    public ResponseEntity<Docter> getDocterByID(@PathVariable String id) {
        Docter getDocter = docterService.getDocterById(id);
        return getDocter != null 
        ? ResponseEntity.ok(getDocter) 
        : ResponseEntity.notFound().build();
    }

    @GetMapping()
    public ResponseEntity<List<Docter>> getMethodName() {
        List<Docter> docters = docterService.getAllDocter();
        return ResponseEntity.ok(docters);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<Docter> updateDocter(@PathVariable String id, @RequestBody Docter docter) {
        Docter upDocter = docterService.updateDocter(id, docter);        
        return upDocter != null 
        ? ResponseEntity.ok(upDocter) 
        : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDocter(@PathVariable String id) {
        String result = docterService.deleteDocter(id);
        return result != null 
        ? ResponseEntity.ok(result) 
        : ResponseEntity.notFound().build();
    }
    
}
