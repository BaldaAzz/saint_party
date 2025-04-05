package com.example.SaintDima.controllers.biography;

import com.example.SaintDima.services.BiographyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/biographies")
@RequiredArgsConstructor
public class BiographyController {

    private final BiographyService biographyService;

    @GetMapping
    public String showBiographyListPage() {
//        Данные обрисовываются с помощью js на самой странице
        return "biography/biography-list";
    }

    @GetMapping("/{id}")
    public String getBiographyPageById(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("biography", biographyService.getBiographyById(id));
        return "biography/biography";
    }
}
