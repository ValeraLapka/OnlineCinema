package ru.edu.bsu.onlinecinema.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.edu.bsu.onlinecinema.persistance.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findFirstByUsername(String username);
}
