package by.timeoutclub.fteam.dao;

import by.timeoutclub.fteam.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer> {
}
