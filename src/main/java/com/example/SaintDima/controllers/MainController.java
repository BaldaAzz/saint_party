package com.example.SaintDima.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String getMainPage() {
        return "index";
    }

    @GetMapping("/map")
    public String getBelarusMapPage() {
        return "map";
    }

    @GetMapping("/calendar")
    public String getCalendarPage() {
        return "calendar";
    }

    @GetMapping("/check-yourself")
    public String getCheckYourselfPage() {
        return "check-yourself";
    }
}
