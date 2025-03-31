package com.example.SaintDima.controllers.prayer;

import com.example.SaintDima.models.Prayer;
import com.example.SaintDima.services.PrayerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/moderation/prayers")
@RequiredArgsConstructor
public class ModerationPrayerController {

    private final PrayerService prayerService;

    @GetMapping
    public String showPrayersList(Model model) {
        model.addAttribute("prayers", prayerService.getAllPrayers());
        return "prayer/moderation-prayer-list";
    }

    @GetMapping("/new")
    public String showAddPrayerPage(Model model) {
        model.addAttribute("prayer", new Prayer());
        return "prayer/new-prayer";
    }

    @GetMapping("/{id}/edit")
    public String showEditPrayerPage(Model model, @PathVariable Long id) {
        model.addAttribute("prayer", prayerService.getPrayerById(id));

        return "prayer/edit-prayer";
    }

    @PostMapping
    public String addPrayer(@Valid @ModelAttribute("prayer") Prayer prayer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            if (prayer.getId() != null) {
                return "redirect:/moderation/prayers/" + prayer.getId() + "/edit";
            }

            return "redirect:/moderation/prayers/new";
        }

        prayerService.createOrUpdatePrayer(prayer);

        return "redirect:/moderation/prayers";
    }

    @GetMapping("/{id}/delete")
    public String deletePrayer(@PathVariable Long id) {
        prayerService.deletePrayer(id);
        return "redirect:/moderation/prayers";
    }
}
