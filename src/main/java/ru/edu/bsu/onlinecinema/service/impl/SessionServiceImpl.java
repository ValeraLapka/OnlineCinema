package ru.edu.bsu.onlinecinema.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.edu.bsu.onlinecinema.persistance.dto.SessionDto;
import ru.edu.bsu.onlinecinema.persistance.mapper.SessionMapper;
import ru.edu.bsu.onlinecinema.persistance.model.Session;
import ru.edu.bsu.onlinecinema.persistance.repository.SessionRepository;
import ru.edu.bsu.onlinecinema.service.SessionService;

import java.time.LocalDateTime;
import java.util.List;
@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepository;
    private final SessionMapper sessionMapper;

    @Override
    public List<SessionDto> getAllSession() {
        return sessionMapper.toSessionDtos(sessionRepository.findAll());
    }

    @Override
    public List<SessionDto> getSessionByFilm(String filmName) {
        return sessionMapper.toSessionDtos(sessionRepository.findAllByFilmNameContainingIgnoreCase(filmName));
    }

    @Override
    public Session getSessionByFilmAndTime(String filmName, LocalDateTime time) {
        return sessionRepository.findFirstByFilmNameAndTimeBetween(filmName,time.minusMinutes(1),time.plusMinutes(1))
                .orElseThrow(()->new RuntimeException("session not found"));
    }

    @Override
    public Session save(Session session) {
        return sessionRepository.save(session);
    }
}
