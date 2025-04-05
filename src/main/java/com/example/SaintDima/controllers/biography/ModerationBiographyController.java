package com.example.SaintDima.controllers.biography;

import com.example.SaintDima.models.Biography;
import com.example.SaintDima.services.BiographyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/moderation/biographies")
@RequiredArgsConstructor
public class ModerationBiographyController {

    private final BiographyService biographyService;

    @GetMapping
    public String showBiographyList(Model model) {
        model.addAttribute("biographies", biographyService.getAllBiographies());
        return "biography/moderation-biography-list";
    }

    @GetMapping("/new")
    public String showAddBiographyPage(Model model) {
        model.addAttribute("biography", new Biography());
        return "biography/new-biography";
    }

    @GetMapping("/{id}/edit")
    public String showEditBiographyPage(Model model, @PathVariable Long id) {
        model.addAttribute("biography", biographyService.getBiographyById(id));
        return "biography/edit-biography";
    }

    @PostMapping("/new")
    public String addBiography(
            Model model,
            @ModelAttribute Biography biography,
            @RequestParam("imageInput") MultipartFile file,
            BindingResult bindingResult
    ) throws IOException {
        if (bindingResult.hasErrors()) {
            return "redirect:/moderation/biographies/new";
        }
        biographyService.createBiography(biography, file);

        return "redirect:/moderation/biographies";
    }

    @PostMapping("/update")
    public String updateBiography(
            Model model,
            @ModelAttribute Biography biography,
            @RequestParam("imageInput") MultipartFile file,
            BindingResult bindingResult
    ) throws IOException {
        if (bindingResult.hasErrors()) {
            return "redirect:/moderation/biographies/" + biography.getId() + "/edit";
        }
        biographyService.updateBiography(biography, file);

        return "redirect:/moderation/biographies";
    }

    @GetMapping("/{id}/delete")
    public String deleteArticle(Model model, @PathVariable Long id) throws IOException {
        biographyService.deleteBiography(id);
        return "redirect:/moderation/articles";
    }
}
