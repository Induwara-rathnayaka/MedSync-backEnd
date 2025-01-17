package com.medsync.Medsync_booking.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Document(collection = "Patient")
public class Patient {

    @Id 
    private String NIC;
    private String name;
    private String ContactNo;
    private String email;
    private String Password;
        
}
