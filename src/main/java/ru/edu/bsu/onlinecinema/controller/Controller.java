package ru.edu.bsu.onlinecinema.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.edu.bsu.onlinecinema.persistance.dto.FilterDto;
import ru.edu.bsu.onlinecinema.persistance.dto.SessionDto;
import ru.edu.bsu.onlinecinema.persistance.dto.UserDto;
import ru.edu.bsu.onlinecinema.service.OrderService;
import ru.edu.bsu.onlinecinema.service.SessionService;
import ru.edu.bsu.onlinecinema.service.UserService;

@org.springframework.stereotype.Controller
@RequiredArgsConstructor
public class Controller {
    private final UserService userService;
    private final SessionService sessionService;
    private final OrderService orderService;

    @GetMapping("/registration")
    public String registration(@ModelAttribute("user") UserDto userDto){
        return "registration";
    }
    @PostMapping("/registration")
    public String registrationProcess(@ModelAttribute("user") UserDto userDto){
        userService.registration(userDto);
        return "registration";
    }
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("sessions",sessionService.getAllSession());
        var userNameByAuthContext = userService.getUserByAuthContext().getUsername();
        model.addAttribute("user",userNameByAuthContext);
        model.addAttribute("orders",orderService.getAllOrdersByUserName(userNameByAuthContext));
        model.addAttribute("filter",new FilterDto());
        model.addAttribute("reservation",new SessionDto());
        return "index";
    }
    @PostMapping("/filter-film")
    public String filterFilm(Model model,@ModelAttribute("filter") FilterDto filterDto){
        model.addAttribute("sessions",sessionService.getSessionByFilm(filterDto.getFilmName()));
        var userNameByAuthContext = userService.getUserByAuthContext().getUsername();
        model.addAttribute("user",userNameByAuthContext);
        model.addAttribute("orders",orderService.getAllOrdersByUserName(userNameByAuthContext));
        model.addAttribute("reservation",new SessionDto());
        return "index";
    }

    @PostMapping("/add-reservation")
    public String addReservation(Model model,@ModelAttribute("reservation") SessionDto sessionDto){
        var userNameByAuthContext = userService.getUserByAuthContext().getUsername();
        orderService.addOrderToUser(sessionDto.getFilmName(),sessionDto.getTime());
        model.addAttribute("filter",new FilterDto());
        model.addAttribute("sessions",sessionService.getAllSession());
        model.addAttribute("user",userNameByAuthContext);
        model.addAttribute("orders",orderService.getAllOrdersByUserName(userNameByAuthContext));
        return "index";
    }
}
