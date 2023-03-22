package ru.edu.bsu.onlinecinema.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.edu.bsu.onlinecinema.persistance.model.Session;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session,Integer> {

    List<Session> findAllByFilmName(String filmName);
}
