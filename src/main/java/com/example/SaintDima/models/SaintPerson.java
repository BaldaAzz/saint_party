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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "fathers_name")
    private String fathersName;

    @Column(name = "date_of_birth")
    private Integer dateOfBirth;

    @Column(name = "place_of_birth")
    private String placeOfBirth;

    @Column(name = "date_of_view")
    private Integer dateOfView;

    @Column(name = "place_of_view")
    private String placeOfView;

    @Lob
    @Column(name = "biography")
    private String biography;

    @Column(name = "date_of_memory")
    private String dateOfMemory;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Image image;
}
