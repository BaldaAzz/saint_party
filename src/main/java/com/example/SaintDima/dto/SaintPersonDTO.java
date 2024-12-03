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
    private Integer dateOfBirth;
    private String placeOfBirth;
    private Integer dateOfView;
    private String placeOfView;
    private String biography;
    private String dateOfMemory;
    private String imageUrl;
}
