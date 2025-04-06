package com.example.SaintDima.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/moderation")
public class DashboardController {

    @GetMapping
    public String showDashboard() {
        return "dashboard";
    }
}
