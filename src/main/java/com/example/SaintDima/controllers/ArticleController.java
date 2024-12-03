package com.example.SaintDima.controllers;

import com.example.SaintDima.models.Article;
import com.example.SaintDima.repositories.ArticleRepository;
import com.example.SaintDima.services.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/")
    public String biographyPage(Model model) {
        model.addAttribute("articles", articleService.findAll());
        return "articles";
    }

    @GetMapping("/add")
    public String addBiography() {
        return "add-article";
    }

    @PostMapping("/add")
    public String createBiography(@RequestParam String title,
                                  @RequestParam String content,
                                  @RequestParam("imageInput") MultipartFile file,
                                  Model model) throws IOException {
        articleService.createArticle(title, content, file);

        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String getArticlePageById(@PathVariable(value = "id") Long id,
                                     Model model) {
        Article article = articleService.getArticleById(id);
        model.addAttribute("article", article);
        return "article";
    }
}
