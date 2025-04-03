package com.example.SaintDima.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "articles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Поле не может быть пустым или содержать только знаки пробела!")
    @Size(message = "Название должно быть в диапазоне от 2 до 255 символов!")
    @Column(name = "title", nullable = false)
    private String title;

    @Lob
    @NotBlank(message = "Поле не может быть пустым или содержать только знаки пробела!")
    @Column(name = "content", nullable = false)
    private String text;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Image image;
}
