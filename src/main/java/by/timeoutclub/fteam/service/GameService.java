package by.timeoutclub.fteam.service;

import by.timeoutclub.fteam.dao.EventRepository;
import by.timeoutclub.fteam.dao.GameRepository;
import by.timeoutclub.fteam.dao.PlayerRepository;
import by.timeoutclub.fteam.exception.NotFoundException;
import by.timeoutclub.fteam.model.dto.EventDTO;
import by.timeoutclub.fteam.model.entity.Event;
import by.timeoutclub.fteam.model.entity.Game;
import by.timeoutclub.fteam.model.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private GameRepository gameRepository;
    private PlayerRepository playerRepository;
    private EventRepository eventRepository;

    @Autowired
    public GameService(GameRepository gameRepository, PlayerRepository playerRepository,
                       EventRepository eventRepository) {
        this.gameRepository = gameRepository;
        this.playerRepository = playerRepository;
        this.eventRepository = eventRepository;
    }

    public List<Game> getGames() {
        return gameRepository.findAll();
    }

    public Game getGameById(Integer gameId) {
        return gameRepository.findById(gameId).orElseThrow(() -> new NotFoundException("Game was not found"));
    }

    public Game addGame(Game game) {
        return gameRepository.save(game);
    }

    public Event addEvent(EventDTO eventDto, Integer gameId) {
        Player player = playerRepository.findById(eventDto.getPlayerId()).orElseThrow(() -> new NotFoundException(
                "Player was not found"));
        Game game = gameRepository.findById(gameId).orElseThrow(() -> new NotFoundException("Game was not found"));

        Event event = new Event();
        event.setPlayer(player);
        event.setGame(game);
        event.setType(eventDto.getType());

        return eventRepository.save(event);
    }
}
