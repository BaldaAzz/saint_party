package com.example.SaintDima.controllers.prayer;

import com.example.SaintDima.models.Prayer;
import com.example.SaintDima.services.PrayerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/prayers")
@RequiredArgsConstructor
public class AdminPrayerController {

    private final PrayerService prayerService;

    @GetMapping("/add")
    public String showAddPrayerPage(Model model) {
        model.addAttribute("prayer", new Prayer());
        return "prayer/add-prayer";
    }

    @PostMapping("/add")
    public String addPrayer(@Valid @ModelAttribute("prayer") Prayer prayer, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "prayer/add-prayer";
        }

        prayerService.addPayer(prayer);

        return "redirect:/prayers";
    }
}
