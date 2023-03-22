package ru.edu.bsu.onlinecinema.service;

import ru.edu.bsu.onlinecinema.persistance.dto.UserDto;

public interface UserService {
    void registration(UserDto userDto);
}
