package com.example.SaintDima.controllers;

import com.example.SaintDima.models.Prayer;
import com.example.SaintDima.services.PrayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prayer")
public class PrayerRestController {

    @Autowired
    private PrayerService prayerService;

    @GetMapping("/get")
    public List<Prayer> getPrayers(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "10") int size) {
        return prayerService.getPrayers(page, size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prayer> getPrayerById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(prayerService.getPrayersById(id));
    }
}
