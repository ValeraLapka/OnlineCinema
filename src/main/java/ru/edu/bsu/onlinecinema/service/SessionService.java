package ru.edu.bsu.onlinecinema.service;

import ru.edu.bsu.onlinecinema.persistance.dto.SessionDto;
import ru.edu.bsu.onlinecinema.persistance.model.Session;

import java.time.LocalDateTime;
import java.util.List;

public interface SessionService {
    List<SessionDto> getAllSession();
    List<SessionDto> getSessionByFilm(String filmName);
    Session getSessionByFilmAndTime(String filmName, LocalDateTime time);
    Session save(Session session);
}
