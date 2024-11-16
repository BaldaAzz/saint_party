package com.example.SaintDima.controllers;

import com.example.SaintDima.models.Prayer;
import com.example.SaintDima.repositories.PrayerRepository;
import com.example.SaintDima.services.PrayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/prayers")
@RequiredArgsConstructor
public class PrayerController {

    @Autowired
    private PrayerRepository prayerRepository;
    @Autowired
    private PrayerService prayerService;

    @GetMapping("/")
    public String prayersPage(Model model) {
        List<Prayer> prayers = prayerRepository.findAll();
        model.addAttribute("prayers", prayers);
        return "prayers";
    }

    @GetMapping("/add")
    public String addBiography() {
        return "add-prayer";
    }

    @PostMapping("/add")
    public String createPrayer(@RequestParam String title,
                               @RequestParam String prayer,
                               Model model) throws IOException {
        prayerService.createPrayer(title, prayer);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String getSaintPersonById(@PathVariable(value = "id") Long id,
                                     Model model) {
        Prayer prayer = prayerService.getPrayerById(id);
        model.addAttribute("prayer", prayer);
        return "prayer";
    }
}