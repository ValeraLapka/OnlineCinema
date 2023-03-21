package ru.edu.bsu.onlinecinema.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
@RequiredArgsConstructor
public class Controller {

    @GetMapping("/")
    public String index(Model model){
        return "index";
    }
}
