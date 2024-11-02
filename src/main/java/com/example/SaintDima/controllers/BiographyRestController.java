package com.example.SaintDima.controllers;


import com.example.SaintDima.dto.SaintPersonDTO;
import com.example.SaintDima.models.SaintPerson;
import com.example.SaintDima.services.SaintPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/biography")
@CrossOrigin(origins = "*")
public class BiographyRestController {

    @Autowired
    private SaintPersonService saintPersonService;

    @GetMapping("/get_all")
    public List<SaintPersonDTO> getAllPersons() {
        return saintPersonService.getListBiographies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaintPersonDTO> getBiographyById(@PathVariable(value = "id") Long id) {
        SaintPersonDTO saintPersonDTO = saintPersonService.getByIdSaintBiography(id);
        return ResponseEntity.ok(saintPersonDTO);
    }
}
