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

import com.medsync.Medsync_booking.Model.Admin;
import com.medsync.Medsync_booking.Service.AdminService;

import jakarta.validation.Valid;


@RestController
@Validated
@RequestMapping({"Admin"})
public class AdminContraller {
    @Autowired
    AdminService adminService;

    //create admin 
    @PostMapping({"/create"})
    public ResponseEntity<Admin> createAdmin(@RequestBody @Valid Admin admin) {
        Admin createAdmin = adminService.creatAdmin(admin);
        return ResponseEntity.ok(createAdmin);
    }
    
    //get Admin by id
    @GetMapping({"/getById/{id}"})
    public ResponseEntity<Admin> getAdminByID(@PathVariable String id) {
        Admin getAdmin = adminService.getAdminById(id);
        return getAdmin != null 
        ? ResponseEntity.ok(getAdmin) 
        : ResponseEntity.notFound().build();
    }

    //get all Admins
    @GetMapping({"/getAll"})
    public ResponseEntity<List<Admin>> getAllAdmin() {
        List<Admin> booking = adminService.getAllAdmin();
        return ResponseEntity.ok(booking);
    }

    //Update Admin
    @PutMapping({"/update/{id}"})
    public ResponseEntity<Admin> updateAdmin(@PathVariable String id, @RequestBody Admin admin) {
        Admin upAdmin = adminService.updateAdmin(id, admin);   
        return upAdmin != null 
        ? ResponseEntity.ok(upAdmin) 
        : ResponseEntity.notFound().build();
    }

    //delete Admin
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable String id) {
        String result = adminService.deleteAdmin(id);
        return result != null 
        ? ResponseEntity.ok(result) 
        : ResponseEntity.notFound().build();
    }

    //admin get by id And password
    @PostMapping("/Login/{adminId}/{password}")
    public ResponseEntity<String> searchDocters(@PathVariable String adminId, @PathVariable String password){
        String docters = adminService.loging(adminId, password);
        return ResponseEntity.ok(docters);
    }

}
