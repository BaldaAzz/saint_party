package com.example.SaintDima.controllers.article;

import com.example.SaintDima.services.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping
    public String biographyPage(Model model) {
        model.addAttribute("articles", articleService.getAllArticles());
        return "article/article-list";
    }

    @GetMapping("/{id}")
    public String getArticlePageById(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("article", articleService.getArticleById(id));
        return "article/article";
    }
}
