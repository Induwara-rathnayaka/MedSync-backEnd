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

@Document(collection = "Doctor_Shedule")
public class Shedule {
    
    @Id
    private String ID;
    private String doctorID;
    private String doctorName;
    private LocalDate day;
    private String time;
    private int Count;
    
}
