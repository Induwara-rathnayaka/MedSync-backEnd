package com.medsync.Medsync_booking.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.medsync.Medsync_booking.Model.Docter;
import java.util.List;




public interface DocterRepository extends MongoRepository<Docter,String>{    

}
