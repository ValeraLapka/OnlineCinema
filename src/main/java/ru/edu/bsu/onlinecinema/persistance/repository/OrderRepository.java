package ru.edu.bsu.onlinecinema.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.edu.bsu.onlinecinema.persistance.model.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {

    List<Order> findAllByUserUsername(String username);
}
