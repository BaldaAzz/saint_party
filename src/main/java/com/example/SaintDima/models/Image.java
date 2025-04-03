package com.example.SaintDima.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "images")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "File name cannot be empty!")
    @Column(name = "file_name", nullable = false)
    private String fileName;

    @NotBlank(message = "Path cannot be empty!")
    @Column(name = "path", nullable = false)
    private String path;
}
