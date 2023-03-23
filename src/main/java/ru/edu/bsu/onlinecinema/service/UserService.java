package ru.edu.bsu.onlinecinema.service;

import ru.edu.bsu.onlinecinema.persistance.dto.UserDto;
import ru.edu.bsu.onlinecinema.persistance.model.User;

public interface UserService {
    void registration(UserDto userDto);
    User getUserByAuthContext();
}
