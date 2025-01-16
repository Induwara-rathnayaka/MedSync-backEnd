package com.medsync.Medsync_booking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medsync.Medsync_booking.Model.Channelling;
import com.medsync.Medsync_booking.Service.ChannellingService;

@RestController
@RequestMapping({"Channelling"})
public class ChannellingController {

    @Autowired
    ChannellingService Channelservice;

    @PostMapping({"/create"})
    public ResponseEntity<Channelling> createChannelling(@RequestBody Channelling channelling) {
        Channelling createchannelling = Channelservice.createChannelling(channelling);
        return ResponseEntity.ok(createchannelling);
    }
    
    @PostMapping({"/getById/{id}"})
    public ResponseEntity<Channelling> getChannellingByID(@PathVariable String id) {
        Channelling getchannelling = Channelservice.getChannellingById(id);
        return getchannelling != null 
        ? ResponseEntity.ok(getchannelling) 
        : ResponseEntity.notFound().build();
    }

    @PostMapping({"/getAll"})
    public ResponseEntity<List<Channelling>> getAllChannelling() {
        List<Channelling> channelling = Channelservice.getAllChannelling();
        return ResponseEntity.ok(channelling);
    }

    @PostMapping({"/upload/{id}"})
    public ResponseEntity<Channelling> updateChannelling(@PathVariable String id, @RequestBody Channelling channelling) {
        Channelling upchannelling = Channelservice.updateChannelling(id, channelling);        
        return upchannelling != null 
        ? ResponseEntity.ok(upchannelling) 
        : ResponseEntity.notFound().build();
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteChannelling(@PathVariable String id) {
        String result = Channelservice.deleteChannelling(id);
        return result != null 
        ? ResponseEntity.ok(result) 
        : ResponseEntity.notFound().build();
    }

}