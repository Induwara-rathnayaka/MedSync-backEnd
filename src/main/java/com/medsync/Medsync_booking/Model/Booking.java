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

@Document(collection = "Booking")
public class Booking {
    @Id
    private String id;
    private String PatientEmail;
    private String Doctorname;
    private LocalDate day;
    private String time;
    
}
