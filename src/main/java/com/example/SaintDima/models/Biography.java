package com.example.SaintDima.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "biographies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Biography {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Поле не может быть пустым или содержать только знаки пробела!")
    @Size(min = 2, max = 255, message = "Имя должно быть в диапазоне от 2 до 255 символов!")
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "Поле не может быть пустым или содержать только знаки пробела!")
    @Size(min = 2, max = 255, message = "Данные должны быть в диапазоне от 2 до 255 символов!")
    @Column(name = "surname")
    private String surname;

    @Positive(message = "Год не может быть отрицательным!")
    @Column(name = "date_of_birth")
    private Integer dateOfBirth;

    @Column(name = "place_of_birth")
    private String placeOfBirth;

    @Column(name = "date_of_view")
    private String dateOfView;

    @Column(name = "place_of_view")
    private String placeOfView;

    @Column(name = "date_of_memory")
    private String dateOfMemory;

    @Lob
    @NotBlank(message = "Поле не может быть пустым или содержать только знаки пробела!")
    @Size(min = 2, message = "Содержимое данного поля должно быть больше 2-ух символов!")
    @Column(name = "biography", nullable = false)
    private String text;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Image image;
}
