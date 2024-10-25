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
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private String biography;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Image image;

    public void addImageToSaintPerson(Image image) {
        image.setSaintPerson(this);
    }
//    добавить таблицу со списком мест
//    private List placesOfWorship;

//    добавить таблицу с событиями
//    private List significantEvents;
}
