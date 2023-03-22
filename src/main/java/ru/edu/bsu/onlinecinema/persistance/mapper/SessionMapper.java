package ru.edu.bsu.onlinecinema.persistance.mapper;

import org.springframework.stereotype.Component;
import ru.edu.bsu.onlinecinema.persistance.dto.SessionDto;
import ru.edu.bsu.onlinecinema.persistance.model.Session;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class SessionMapper {

    public SessionDto toSessionDto(Session session){
        SessionDto sessionDto = new SessionDto();
        sessionDto.setFilmName(session.getFilm().getName());
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        sessionDto.setTime(session.getTime().format(formatter));
        sessionDto.setPlaceCount(session.getPlaceCount());
        return sessionDto;
    }

     public List<SessionDto> toSessionDtos(List<Session> sessions){
        return sessions.stream().map(this::toSessionDto).collect(Collectors.toList());
    }
}
