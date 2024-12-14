package com.medsync.Medsync_booking.Model;

import java.time.LocalDate;

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
    private String id;
    private String name;
    private String ContactNo;
    private String NIC;
    private String Address;
    private String email;
    private String DocterID;
    private String paymentMethod;
    private LocalDate day;
    private String time;

}
