package com.medsync.Medsync_booking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medsync.Medsync_booking.Model.Docter;
import com.medsync.Medsync_booking.Service.DocterService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping({"Docter"})
public class DocterController {

    @Autowired
    DocterService docterService;

    @PostMapping({"/create"})
    public ResponseEntity<String> createDopcter(@RequestBody Docter docter) {
        String createdocter = docterService.creatDocter(docter);
        return ResponseEntity.ok(createdocter);
    }
    
    @GetMapping({"/getById/{id}"})
    public ResponseEntity<Docter> getDocterByID(@PathVariable String id) {
        Docter getDocter = docterService.getDocterById(id);
        return getDocter != null 
        ? ResponseEntity.ok(getDocter) 
        : ResponseEntity.notFound().build();
    }

    @GetMapping({"/getAll"})
    public ResponseEntity<List<Docter>> getAllDocter() {
        List<Docter> docters = docterService.getAllDocter();
        return ResponseEntity.ok(docters);
    }

    @PutMapping({"/update/{id}"})
    public ResponseEntity<Docter> updateDocter(@PathVariable String id, @RequestBody Docter docter) {
        Docter upDocter = docterService.updateDocter(id, docter);        
        return upDocter != null 
        ? ResponseEntity.ok(upDocter) 
        : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDocter(@PathVariable String id) {
        String result = docterService.deleteDocter(id);
        return result != null 
        ? ResponseEntity.ok(result) 
        : ResponseEntity.notFound().build();
    }

    @GetMapping("/getByspecialty/{specialty}")
    public ResponseEntity<List<Docter>> getDocterBySpecialty(@PathVariable String specialty){
        List<Docter> docters = docterService.fingBySpecialty(specialty);
        return ResponseEntity.ok(docters);
    }

    @GetMapping("/search/{email}/{password}")
    public ResponseEntity<String> searchDocters(@PathVariable String email, @PathVariable String password){
        String docters = docterService.findByEmailAndPassword(email, password);
        return ResponseEntity.ok(docters);
    }
    
}
