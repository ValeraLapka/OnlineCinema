package ru.edu.bsu.onlinecinema.service;

import ru.edu.bsu.onlinecinema.persistance.dto.SessionDto;
import ru.edu.bsu.onlinecinema.persistance.model.Session;

import java.util.List;

public interface SessionService {
    List<SessionDto> getAllSession();
    List<SessionDto> getSessionByFilm(String filmName);
}
