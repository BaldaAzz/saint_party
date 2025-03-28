package com.example.SaintDima.controllers.prayer;

import com.example.SaintDima.models.Prayer;
import com.example.SaintDima.services.PrayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/prayers")
@RequiredArgsConstructor
public class PrayerController {

    private final PrayerService prayerService;

    @GetMapping()
    public String prayersPage(Model model) {
        List<Prayer> prayers = prayerService.getAllPrayers();
        model.addAttribute("prayers", prayers);
        return "prayer/prayer-list";
    }

    @GetMapping("/{id}")
    public String showPrayerById(@PathVariable(value = "id") Long id, Model model) {
        Prayer prayer = prayerService.getPrayerById(id);
        model.addAttribute("prayer", prayer);
        return "prayer/prayer";
    }
}