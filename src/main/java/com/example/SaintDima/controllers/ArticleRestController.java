package com.example.SaintDima.controllers;


import com.example.SaintDima.models.Article;
import com.example.SaintDima.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/article")
public class ArticleRestController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/get")
    public List<Article> getArticles(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int size) {
        return articleService.getArticles(page, size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(articleService.getArticleById(id));
    }
}
