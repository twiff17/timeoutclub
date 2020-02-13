package by.timeoutclub.fteam.dao;

import by.timeoutclub.fteam.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    Optional<Player> findByName(String name);
}
