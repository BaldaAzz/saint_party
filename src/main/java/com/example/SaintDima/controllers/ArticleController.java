package com.example.SaintDima.controllers;

import com.example.SaintDima.services.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

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

    @PostMapping("/add")
    public String createBiography(@RequestParam String title,
                                  @RequestParam String content,
                                  Model model) throws IOException {
        articleService.createArticle(title, content);

        return "redirect:/";
    }
}
