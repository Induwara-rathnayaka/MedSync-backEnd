package com.medsync.Medsync_booking.Service.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medsync.Medsync_booking.Model.DocterAdmin;
import com.medsync.Medsync_booking.Repository.DocterAdminRepository;
import com.medsync.Medsync_booking.Service.DocterAdminService;

@Service
public class DocterAdminServiseImpl implements DocterAdminService{

    @Autowired
    DocterAdminRepository docterAdminRepository;

    @Override
    public DocterAdmin creatDocterAdmin(DocterAdmin docterAdmin) {
        return docterAdminRepository.save(docterAdmin);
    }

    @Override
    public DocterAdmin getDocterAdminById(String id) {
        Optional<DocterAdmin> docter = docterAdminRepository.findById(id); 
        return docter.orElse(null); 
    }

    @Override
    public List<DocterAdmin> getAllDocterAdmins() {
        return docterAdminRepository.findAll();
    }

    @Override
    public DocterAdmin updateDocterAdmin(String id, DocterAdmin docterAdmin) {
        if (docterAdminRepository.existsById(id)) {
            docterAdmin.setId(id);
            return docterAdminRepository.save(docterAdmin);
        }
        return null;
    }

    @Override
    public String deleteDocteradmin(String id) {
        if (docterAdminRepository.existsById(id)) {
            docterAdminRepository.deleteById(id);
            return "delete Sucsessfull";
        }
        return "Docter Admin not found";
    }
}