package com.example.SaintDima.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "monasteries")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Monastery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameOfMonastery;
    private String information;
}
