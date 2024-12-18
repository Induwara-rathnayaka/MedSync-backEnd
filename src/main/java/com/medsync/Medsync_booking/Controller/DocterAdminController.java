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
import org.springframework.web.bind.annotation.PathVariable;
//http://localhost:8080/swagger-ui/index.html#/
@RestController
@RequestMapping({"Docter_Admin"})
public class DocterAdminController {

    @Autowired
    DocterAdminService docterAdminService;

    @PostMapping({"/create"})
    public ResponseEntity<DocterAdmin> createDocterAdmin(@RequestBody DocterAdmin docterAdmin) {
        DocterAdmin docter = docterAdminService.creatDocterAdmin(docterAdmin);
        return ResponseEntity.ok(docter);
    }

    @PostMapping("/getById/{id}")
    public ResponseEntity<DocterAdmin> getDocterAdminById(@PathVariable String id) {
        DocterAdmin docterAdmin = docterAdminService.getDocterAdminById(id);
        return docterAdmin != null 
            ? ResponseEntity.ok(docterAdmin) 
            : ResponseEntity.notFound().build();
    }

    @PostMapping({"/getAll"})
    public ResponseEntity<List<DocterAdmin>> getAllDocterAdmin() {
        List<DocterAdmin> docters = docterAdminService.getAllDocterAdmins();
        return ResponseEntity.ok(docters);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<DocterAdmin> updateDocterAdmin(@PathVariable String id, @RequestBody DocterAdmin docterAdmin) {
        DocterAdmin updatedDocterAdmin = docterAdminService.updateDocterAdmin(id, docterAdmin);
        return updatedDocterAdmin != null 
            ? ResponseEntity.ok(updatedDocterAdmin) 
            : ResponseEntity.notFound().build();
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteDocterAdmin(@PathVariable String id) {
        String result = docterAdminService.deleteDocteradmin(id);
        return result != null 
            ? ResponseEntity.ok(result) 
            : ResponseEntity.notFound().build();
    }
}
