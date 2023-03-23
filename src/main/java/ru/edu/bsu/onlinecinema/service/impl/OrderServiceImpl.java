package ru.edu.bsu.onlinecinema.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.edu.bsu.onlinecinema.persistance.dto.SessionDto;
import ru.edu.bsu.onlinecinema.persistance.mapper.SessionMapper;
import ru.edu.bsu.onlinecinema.persistance.model.Order;
import ru.edu.bsu.onlinecinema.persistance.model.Session;
import ru.edu.bsu.onlinecinema.persistance.repository.OrderRepository;
import ru.edu.bsu.onlinecinema.service.OrderService;
import ru.edu.bsu.onlinecinema.service.SessionService;
import ru.edu.bsu.onlinecinema.service.UserService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final SessionMapper sessionMapper;
    private final UserService userService;
    private final SessionService sessionService;

    @Override
    public List<SessionDto> getAllOrdersByUserName(String username) {
        var orders = orderRepository.findAllByUserUsername(username);
        return orders.stream()
                .map(order -> sessionMapper.toSessionDto(order.getSession()))
                .collect(Collectors.toList());
    }

    @Override
    public void addOrderToUser(String film, String time) {
        var order = new Order();
        order.setUser(userService.getUserByAuthContext());
        var parseDate = LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        var sessionByFilmAndTime = sessionService.getSessionByFilmAndTime(film, parseDate);
        var placeCount=sessionByFilmAndTime.getPlaceCount();
        if (placeCount<1){
            throw new RuntimeException("no free places");
        }
        sessionByFilmAndTime.setPlaceCount(placeCount-1);
        var updatedSession = sessionService.save(sessionByFilmAndTime);
        order.setSession(updatedSession);
        orderRepository.save(order);
    }

}
