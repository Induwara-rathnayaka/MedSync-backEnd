package com.medsync.Medsync_booking.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @Indexed(unique = true)
    private int age;

    private String name;

    @Indexed(unique = true)
    private String ContactNo;

    @NotNull
    @Indexed(unique = true)
    private String email;

    @NotNull
    @Size(min = 6)
    private String Password;
        
}
