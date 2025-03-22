package com.example.SaintDima.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

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

    @NotBlank(message = "Name cannot be empty!")
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname")
    private String surname;

    @Past(message = "Date of birth cannot be in future!")
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "place_of_birth")
    private String placeOfBirth;

    @Past(message = "Date of view cannot be in future!")
    @Column(name = "date_of_view")
    private LocalDate dateOfView;


    @Column(name = "place_of_view")
    private String placeOfView;

    @Lob
    @NotBlank(message = "Biography cannot be empty!")
    @Column(name = "biography", nullable = false)
    private String biography;

    @Column(name = "date_of_memory")
    private LocalDate dateOfMemory;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Image image;
}
