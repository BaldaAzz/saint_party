package com.example.SaintDima.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Saint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String fathersName;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private String picturePath;
    private String biography;

//    добавить таблицу со списком мест
//    private List placesOfWorship;

//    добавить таблицу с событиями
//    private List significantEvents;
}
