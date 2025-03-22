package com.example.SaintDima.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "Title cannot be empty!")
    @Column(name = "title", nullable = false)
    private String title;

    @Lob
    @NotBlank(message = "Prayer cannot be empty!")
    @Column(name = "prayer", nullable = false)
    private String prayer;
}
