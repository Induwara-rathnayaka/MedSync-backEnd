package com.medsync.Medsync_booking.Service;

import java.util.List;

import com.medsync.Medsync_booking.Model.DocterAdmin;

public interface DocterAdminService {
    DocterAdmin creatDocterAdmin(DocterAdmin docterAdmin);
    DocterAdmin getDocterAdminById(String id);
    List<DocterAdmin> getAllDocterAdmins();
    DocterAdmin updateDocterAdmin(String id , DocterAdmin docterAdmin);
    String deleteDocteradmin(String id);
}
