package com.example.SaintDima.controllers;

import com.example.SaintDima.dto.SaintPersonDTO;
import com.example.SaintDima.models.Prayer;
import com.example.SaintDima.services.PrayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/prayers")
@RequiredArgsConstructor
public class PrayerController {

    @Autowired
    private PrayerService prayerService;

    @GetMapping("/")
    public String biographyPage() {
//        Данные отрисовываются с помощью js на самой странице
        return "prayers";
    }

    @GetMapping("/add")
    public String addBiography() {
        return "add-prayer";
    }

    @GetMapping("/{id}")
    public String getSaintPersonById(@PathVariable(value = "id") Long id,
                                     Model model) {
        Prayer prayer = prayerService.getPrayersById(id);
        model.addAttribute("prayer", prayer);
        return "prayer";
    }
}
