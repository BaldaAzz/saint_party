package com.example.SaintDima.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaintPersonDTO {

    private Long id;
    private String name;
    private String surname;
    private String fathersName;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private String biography;
    private String rank;
    private String region;
    private String typeOfFeat;
    private String imageUrl;
}
