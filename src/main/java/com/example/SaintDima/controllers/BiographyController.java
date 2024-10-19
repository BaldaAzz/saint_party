package com.example.SaintDima.controllers;

import com.example.SaintDima.models.Saint;
import com.example.SaintDima.services.SaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
public class BiographyController {

    @Autowired
    private SaintService saintService;

    private static final String UPLOAD_DIRECTORY = "uploads/";


    @GetMapping("/")
    public String biographyPage(Model model) {
//        Добавить отображение всех данных из бд
        return "biography";
    }

    @GetMapping("/add")
    public String addBiography(Model model) {
        return "addBiography";
    }

    @GetMapping("/{id}")
    public String getBiographyById(Model model) {
        return "";
    }

    @PostMapping("/add")
    public String createBiography(@RequestParam String name,
                                  @RequestParam String surName,
                                  @RequestParam String fathersName,
                                  @RequestParam LocalDate dateOfBirth,
                                  @RequestParam LocalDate dateOfDeath,
                                  @RequestParam String biography,
                                  @RequestParam("imageInput") MultipartFile file,
                                  RedirectAttributes redirectAttributes,
                                  Model model) {

        if(file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Выбирете файл для загрузки!");
            return "redirect:/";
        }

        try {
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path path = Paths.get(UPLOAD_DIRECTORY + fileName);
            Files.createDirectories(path.getParent());
            Files.write(path, file.getBytes());

            Saint saint = new Saint(name,
                    surName,
                    fathersName,
                    dateOfBirth,
                    dateOfDeath,
                    biography,
                    path.toString());

            saintService.createSaintBiography(saint);

            redirectAttributes.addFlashAttribute("message", "Файл успешно загружен!" + fileName);
        }
        catch (IOException e) {
            redirectAttributes.addFlashAttribute("message", "Ошибка при загрузке файла!" + e.getMessage());
        }

        return "redirect:/";
    }
}
