package ru.edu.bsu.onlinecinema.service;

import ru.edu.bsu.onlinecinema.persistance.dto.SessionDto;

import java.util.List;

public interface OrderService {
    List<SessionDto> getAllOrdersByUserName(String username);
    void addOrderToUser(String film,String time);
}
