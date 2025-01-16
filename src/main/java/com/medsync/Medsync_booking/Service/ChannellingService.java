package com.medsync.Medsync_booking.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medsync.Medsync_booking.Model.Channelling;
import com.medsync.Medsync_booking.Repository.ChannellingRepository;

@Service
public class ChannellingService {

    @Autowired
    ChannellingRepository Repo;

    public Channelling createChannelling(Channelling channel){
        return Repo.save(channel);
    }

    public Channelling getChannellingById(String id){
        Optional<Channelling> channel = Repo.findById(id);
        return channel.orElse(null);
    }

    public  List<Channelling> getAllChannelling(){
        return Repo.findAll();
    }

    public Channelling updateChannelling(String id , Channelling channel){
        if (Repo.existsById(id)) {
            channel.setId(id);
            return Repo.save(channel);
        }
        return null;
    }

    public String deleteChannelling(String id){
        if (Repo.existsById(id)) {
            Repo.deleteById(id);
            return "Delete Suscessfull";
        }
        return "Channelling not found";
    }
}

