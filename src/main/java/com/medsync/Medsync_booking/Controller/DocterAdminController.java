package com.medsync.Medsync_booking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medsync.Medsync_booking.Model.DocterAdmin;
import com.medsync.Medsync_booking.Service.DocterAdminService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping({"api/Docter_Admin"})
public class DocterAdminController {
    @Autowired
    DocterAdminService docterAdminService;

    @PostMapping
    public ResponseEntity<DocterAdmin> createDocterAdmin(@RequestBody DocterAdmin docterAdmin) {
        DocterAdmin docter = docterAdminService.creatDocterAdmin(docterAdmin);
        return ResponseEntity.ok(docter);
    }

    @GetMapping({"/{Id}"})
    public ResponseEntity<DocterAdmin> getDocterAdminById(@PathVariable String id) {
        DocterAdmin docterAdmin = docterAdminService.getDocterAdminById(id);
        //Optional<DocterAdmin> docter = docterAdminRepository.findById(1001);
        return docterAdmin != null ? ResponseEntity.ok(docterAdmin) : ResponseEntity.notFound().build();
        //return ResponseEntity.ok(docter);
        //return ResponseEntity.ok(Id);
    }

    @GetMapping
    public ResponseEntity<List<DocterAdmin>> getAllDocterAdmin() {
        List<DocterAdmin> docters = docterAdminService.getAllDocterAdmins();
        return ResponseEntity.ok(docters);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocterAdmin> updateDocterAdmin(@PathVariable String id, @RequestBody DocterAdmin docterAdmin) {
        DocterAdmin docter = docterAdminService.updateDocterAdmin(id,docterAdmin);
        return docter != null ? ResponseEntity.ok(docter) : ResponseEntity.notFound().build();
    }

    @DeleteMapping({"/{Id}"})
    public ResponseEntity<String> deleterDocterAdmin(@PathVariable String id){
        String result = docterAdminService.deleteDocteradmin(id);
        return ResponseEntity.ok(result);
    }

}
