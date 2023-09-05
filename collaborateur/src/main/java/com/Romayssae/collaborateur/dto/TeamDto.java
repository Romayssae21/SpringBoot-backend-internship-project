package com.Romayssae.collaborateur.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamDto {
    @NotNull(message = "Username could not be null")
    private String firstName;
    @NotNull(message = "Username could not be null")
    private String lastName;
    @Email(message = "Invalid email address")
    private  String email;
    @NotNull
    @Pattern(regexp="^\\d{10}$", message = "Invalid mobile number")
    private String phoneNumber;

}
