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

import com.medsync.Medsync_booking.Model.Admin;
import com.medsync.Medsync_booking.Service.AdminService;


@RestController
@RequestMapping({"Admin"})
public class AdminContraller {
    @Autowired
    AdminService adminService;

    @PostMapping({"/create"})
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        Admin createAdmin = adminService.creatAdmin(admin);
        return ResponseEntity.ok(createAdmin);
    }
    
    @GetMapping({"/getById/{id}"})
    public ResponseEntity<Admin> getAdminByID(@PathVariable String id) {
        Admin getAdmin = adminService.getAdminById(id);
        return getAdmin != null 
        ? ResponseEntity.ok(getAdmin) 
        : ResponseEntity.notFound().build();
    }

    @GetMapping({"/getAll"})
    public ResponseEntity<List<Admin>> getAllAdmin() {
        List<Admin> booking = adminService.getAllAdmin();
        return ResponseEntity.ok(booking);
    }

    @PutMapping({"/update/{id}"})
    public ResponseEntity<Admin> updateAdmin(@PathVariable String id, @RequestBody Admin admin) {
        Admin upAdmin = adminService.updateAdmin(id, admin);   
        return upAdmin != null 
        ? ResponseEntity.ok(upAdmin) 
        : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable String id) {
        String result = adminService.deleteAdmin(id);
        return result != null 
        ? ResponseEntity.ok(result) 
        : ResponseEntity.notFound().build();
    }

}
