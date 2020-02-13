package by.timeoutclub.fteam.dao;

import by.timeoutclub.fteam.model.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByPlayerId(Integer playerId);
}
