package com.medsync.Medsync_booking.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medsync.Medsync_booking.Model.DocterAdmin;
import com.medsync.Medsync_booking.Repository.DocterAdminRepository;

@Service
public class DocterAdminService {
    @Autowired
    DocterAdminRepository Repo;

    public DocterAdmin creatDocterAdmin(DocterAdmin docter){
        return Repo.save(docter);
    }

    public DocterAdmin getDocterAdminById(String id){
        Optional<DocterAdmin> docter = Repo.findById(id); 
        return docter.orElse(null);
    }

    public  List<DocterAdmin> getAllDocterAdmins(){
        return Repo.findAll();
    }

    public DocterAdmin updateDocterAdmin(String id , DocterAdmin docterAdmin){
        if (Repo.existsById(id)) {
            docterAdmin.setId(id);
            return Repo.save(docterAdmin);
        }
        return null;
    }

    public String deleteDocteradmin(String id){
        if (Repo.existsById(id)) {
            Repo.deleteById(id);
            return "Delete Suscessfull";
        }
        return "Docter Admin not found";
    }
}
