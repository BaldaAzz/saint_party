package com.example.SaintDima.controllers;


import com.example.SaintDima.dto.SaintPersonDTO;
import com.example.SaintDima.services.SaintPersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/biography")
@CrossOrigin(origins = "*")
public class BiographyRestController {

    @Autowired
    private SaintPersonService saintPersonService;

    @GetMapping("/get")
    public List<SaintPersonDTO> getSaintPersons(@RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "10") int size,
                                                @RequestParam(required = false) String place,
                                                @RequestParam(required = false) Integer minBirthDate,
                                                @RequestParam(required = false) Integer maxBirthDate) {
        return saintPersonService.getFilteredListBiographies(place, minBirthDate, maxBirthDate, page, size);
    }
}
