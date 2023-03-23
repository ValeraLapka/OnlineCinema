package ru.edu.bsu.onlinecinema.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.edu.bsu.onlinecinema.persistance.model.Session;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session,Integer> {

    List<Session> findAllByFilmNameContainingIgnoreCase(String filmName);
    Optional<Session> findFirstByFilmNameAndTimeBetween(String filmName, LocalDateTime timeBefore,LocalDateTime timeAfter);
}
