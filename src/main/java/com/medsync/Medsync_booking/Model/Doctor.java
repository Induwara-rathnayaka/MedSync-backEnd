package com.medsync.Medsync_booking.Model;

import org.springframework.data.annotation.Id;
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

@Document(collection = "Doctor")
public class Doctor {

    @Id
    private String docterID;
    private String name;
    private String contactNumber;

    @NotNull
    private String email;

    @NotNull
    private String specialty;

    @NotNull
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

}
