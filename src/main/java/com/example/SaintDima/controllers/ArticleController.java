package com.example.SaintDima.controllers;

import com.example.SaintDima.services.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/")
    public String biographyPage() {
//        Данные отрисовываются с помощью js на самой странице
        return "articles";
    }

    @GetMapping("/add")
    public String addBiography() {
        return "add-article";
    }

//    @PostMapping("/add")
//    public String createBiography(@RequestParam String title,
//                                  @RequestParam String ,
//                                  @RequestParam String fathersName,
//                                  Model model) throws IOException {
//
//
//        SaintPerson saintPerson = new SaintPerson();
//        saintPerson.setName(name);
//        saintPerson.setSurname(surName);
//        saintPerson.setFathersName(fathersName);
//        saintPerson.setDateOfBirth(dateOfBirth);
//        saintPerson.setDateOfDeath(dateOfDeath);
//        saintPerson.setBiography(biography);
//        saintPerson.setTypeOfFeat(typeOfFeat);
//        saintPerson.setRegion(region);
//        saintPerson.setRank(rank);
//        // поле image заполняется в сервисе
//
//        saintPersonService.createSaintBiography(saintPerson, file);
//
//        redirectAttributes.addFlashAttribute("message", "Файл успешно загружен!");
//
//        return "redirect:/";
//    }
}
