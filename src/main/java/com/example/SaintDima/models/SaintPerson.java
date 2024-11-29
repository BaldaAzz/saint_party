package com.example.SaintDima.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "saint_persons")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaintPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String fathersName;
    private Integer dateOfBirth;
    private Integer dateOfDeath;
    private String biography;
    private String rank;
    private String region;
    private String typeOfFeat;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Image image;
}
