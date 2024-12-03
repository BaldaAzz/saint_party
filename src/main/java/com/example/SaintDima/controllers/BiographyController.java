package com.example.SaintDima.controllers;

import com.example.SaintDima.dto.SaintPersonDTO;
import com.example.SaintDima.services.SaintPersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequestMapping("/biography")
@RequiredArgsConstructor
public class BiographyController {

    @Autowired
    private SaintPersonService saintPersonService;

    @GetMapping("/")
    public String biographyPage() {
//        Данные отрисовываются с помощью js на самой странице
        return "saint-persons-biography";
    }

    @GetMapping("/add")
    public String addBiography() {
        return "add-biography";
    }

    @PostMapping("/add")
    public String createBiography(@RequestParam String name,
                                  @RequestParam String surName,
                                  @RequestParam String fathersName,
                                  @RequestParam Integer dateOfBirth,
                                  @RequestParam String placeOfBirth,
                                  @RequestParam Integer dateOfView,
                                  @RequestParam String placeOfView,
                                  @RequestParam String biography,
                                  @RequestParam String dateOfMemory,
                                  @RequestParam("imageInput") MultipartFile file,
                                  RedirectAttributes redirectAttributes,
                                  Model model) throws IOException {

        if(file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Выбирете файл для загрузки!");
        }
        saintPersonService.createSaintBiography(name,
                surName,
                fathersName,
                dateOfBirth,
                placeOfBirth,
                dateOfView,
                placeOfView,
                biography,
                dateOfMemory,
                file);

        redirectAttributes.addFlashAttribute("message", "Файл успешно загружен!");

        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String getSaintPersonById(@PathVariable(value = "id") Long id,
                                     Model model) {
        SaintPersonDTO saintPersonDTO = saintPersonService.getByIdSaintBiography(id);
        model.addAttribute("saintPersonDTO", saintPersonDTO);
        return "biography";
    }
}
