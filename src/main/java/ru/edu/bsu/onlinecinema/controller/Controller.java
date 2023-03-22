package ru.edu.bsu.onlinecinema.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.edu.bsu.onlinecinema.persistance.UserDto;
import ru.edu.bsu.onlinecinema.service.UserService;

@org.springframework.stereotype.Controller
@RequiredArgsConstructor
public class Controller {
    private final UserService userService;

    @GetMapping("/registration")
    public String registration(@ModelAttribute("user") UserDto userDto){
        return "registration";
    }
    @PostMapping("/registration")
    public String registrationProcess(@ModelAttribute("user") UserDto userDto){
        userService.registration(userDto);
        return "registration";
    }

}
