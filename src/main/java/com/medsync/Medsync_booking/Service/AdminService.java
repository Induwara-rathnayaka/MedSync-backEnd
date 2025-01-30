package com.medsync.Medsync_booking.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medsync.Medsync_booking.Model.Admin;
import com.medsync.Medsync_booking.Repository.AdminReopository;


@Service
public class AdminService {
    
    @Autowired
    AdminReopository Repo;

    public Admin creatAdmin(Admin admin){
        return Repo.save(admin);
    }

    public Admin getAdminById(String id){
        Optional<Admin> admin = Repo.findById(id); 
        return admin.orElse(null);
    }

    public  List<Admin> getAllAdmin(){
        return Repo.findAll();
    }

    public Admin updateAdmin(String id , Admin admin){
        if (Repo.existsById(id)) {
            admin.setAdminId(id);
            return Repo.save(admin);
        }
        return null;
    }

    public String deleteAdmin(String id){
        if (Repo.existsById(id)) {
            Repo.deleteById(id);
            return "Delete Suscessfull";
        }
        return "Admin not found";
    }

    public String loging(String adminId, String password){
        Optional<Admin> admin = Repo.findByEmailAndPassword(adminId, password);

        if (admin.isPresent()) {
            return "Login Sucsessfull";

        }else{
            return "Admin not found";
        }
    }
}
