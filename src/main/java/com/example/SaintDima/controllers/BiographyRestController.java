package com.example.SaintDima.controllers;


import com.example.SaintDima.dto.SaintPersonDTO;
import com.example.SaintDima.services.SaintPersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/biography")
//@CrossOrigin(origins = "*")
public class BiographyRestController {

    @Autowired
    private SaintPersonService saintPersonService;

    @GetMapping("/get")
    public List<SaintPersonDTO> getSaintPersons(@RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "10") int size,
                                                @RequestParam(required = false) String rank,
                                                @RequestParam(required = false) String region,
                                                @RequestParam(required = false) String typeOfFeat) {
        return saintPersonService.getFilteredListBiographies(rank, region, typeOfFeat, page, size);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<SaintPersonDTO> getSaintPersonById(@PathVariable(value = "id") Long id) {
//        SaintPersonDTO saintPersonDTO = saintPersonService.getByIdSaintBiography(id);
//        return ResponseEntity.ok(saintPersonDTO);
//    }
}
