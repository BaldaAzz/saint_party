package com.example.SaintDima.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "prayers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Поле не может быть пустым или содержать только знаки пробела!")
    @Size(min = 2, max = 255, message = "Название должно быть в диапазоне от 2 до 255 символов!")
    @Column(name = "title", nullable = false)
    private String title;

    @NotBlank(message = "Поле не может быть пустым или содержать только знаки пробела!")
    @Size(min = 2, message = "Содержимое данного поля должно быть больше 2-ух символов!")
    @Lob
    @Column(name = "text", nullable = false)
    private String text;
}
