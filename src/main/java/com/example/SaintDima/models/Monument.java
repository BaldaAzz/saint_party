package com.example.SaintDima.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "monuments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Monument {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameOfMonument;
    private String information;
}
