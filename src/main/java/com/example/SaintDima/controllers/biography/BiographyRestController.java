package com.example.SaintDima.controllers.biography;


import com.example.SaintDima.models.Biography;
import com.example.SaintDima.services.BiographyService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class BiographyRestController {

    private final BiographyService biographyService;

    @GetMapping("/biographies")
    public List<Biography> getSaintPersons(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String place,
            @RequestParam(required = false) Integer minBirthDate,
            @RequestParam(required = false) Integer maxBirthDate
    ) {
        return biographyService.getFilteredListBiographies(place, minBirthDate, maxBirthDate, page, size);
    }
}
