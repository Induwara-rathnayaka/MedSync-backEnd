package com.medsync.Medsync_booking.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.medsync.Medsync_booking.Model.Admin;
import com.medsync.Medsync_booking.Repository.AdminReopository;


@Service
public class AdminService {

    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    AdminReopository Repo;

    public Admin creatAdmin(Admin admin){
        Admin newAdd = admin;
        newAdd.setPassword(passwordEncoder.encode(newAdd.getPassword()));
        return Repo.save(newAdd);
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
            Admin newAdd = admin;
            newAdd.setPassword(passwordEncoder.encode(newAdd.getPassword()));
            return Repo.save(newAdd);
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

        if (Repo.existsById(adminId)) {

            Optional<Admin> check = Repo.findById(adminId);

            String pas = check.get().getPassword();

            if(passwordEncoder.matches(password, pas)){

                return "Login Sucsessfull";

            }  else{

                return "Password Doesn't match";
            }
        }

        else{

            return "Admin not found";
            
        }

    }
}
