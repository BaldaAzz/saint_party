package com.example.SaintDima.controllers.article;

import com.example.SaintDima.models.Article;
import com.example.SaintDima.services.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/moderation/articles")
@RequiredArgsConstructor
public class ModerationArticleController {

    private final ArticleService articleService;

    @GetMapping
    public String showArticleList(Model model) {
        model.addAttribute("articles", articleService.getAllArticles());
        return "article/moderation-article-list";
    }

    @GetMapping("/new")
    public String showAddArticlePage(Model model) {
        model.addAttribute("article", new Article());
        return "article/new-article";
    }

    @GetMapping("/{id}/edit")
    public String showEditArticlePage(Model model, @PathVariable Long id) {
        model.addAttribute("article", articleService.getArticleById(id));
        return "article/edit-article";
    }

    @PostMapping("/new")
    public String addArticle(
            Model model,
            @ModelAttribute Article article,
            @RequestParam("imageInput") MultipartFile file,
            BindingResult bindingResult
    ) throws IOException {
        if (bindingResult.hasErrors()) {
            return "redirect:/moderation/articles/new";
        }
        articleService.createArticle(article, file);

        return "redirect:/moderation/articles";
    }

    @PostMapping("/update")
    public String updateArticle(
            Model model,
            @ModelAttribute Article article,
            @RequestParam("imageInput") MultipartFile file,
            BindingResult bindingResult
    ) throws IOException {
        if (bindingResult.hasErrors()) {
            return "redirect:/moderation/articles/" + article.getId() + "/edit";
        }
        articleService.updateArticle(article, file);

        return "redirect:/moderation/articles";
    }

    @GetMapping("/{id}/delete")
    public String deleteArticle(Model model, @PathVariable Long id) throws IOException {
        articleService.deleteArticle(id);
        return "redirect:/moderation/articles";
    }
}
