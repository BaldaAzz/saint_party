package com.example.SaintDima.controllers;

import com.example.SaintDima.dto.SaintPersonDTO;
import com.example.SaintDima.models.SaintPerson;
import com.example.SaintDima.services.SaintPersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

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
                                  @RequestParam LocalDate dateOfBirth,
                                  @RequestParam LocalDate dateOfDeath,
                                  @RequestParam String biography,
                                  @RequestParam String rank,
                                  @RequestParam String region,
                                  @RequestParam String typeOfFeat,
                                  @RequestParam("imageInput") MultipartFile file,
                                  RedirectAttributes redirectAttributes,
                                  Model model) throws IOException {

        if(file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Выбирете файл для загрузки!");
        }

            SaintPerson saintPerson = new SaintPerson();
            saintPerson.setName(name);
            saintPerson.setSurname(surName);
            saintPerson.setFathersName(fathersName);
            saintPerson.setDateOfBirth(dateOfBirth);
            saintPerson.setDateOfDeath(dateOfDeath);
            saintPerson.setBiography(biography);
            saintPerson.setTypeOfFeat(typeOfFeat);
            saintPerson.setRegion(region);
            saintPerson.setRank(rank);
            // поле image заполняется в сервисе

            saintPersonService.createSaintBiography(saintPerson, file);

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
