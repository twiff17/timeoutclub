package by.timeoutclub.fteam.service;

import by.timeoutclub.fteam.dao.EventRepository;
import by.timeoutclub.fteam.dao.PlayerRepository;
import by.timeoutclub.fteam.exception.DuplicationException;
import by.timeoutclub.fteam.exception.NotFoundException;
import by.timeoutclub.fteam.model.dto.PlayerStatistics;
import by.timeoutclub.fteam.model.entity.Event;
import by.timeoutclub.fteam.model.entity.EventType;
import by.timeoutclub.fteam.model.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    private PlayerRepository playerRepository;
    private EventRepository eventRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, EventRepository eventRepository) {
        this.playerRepository = playerRepository;
        this.eventRepository = eventRepository;
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerById(Integer playerId) {
        return playerRepository.findById(playerId).orElseThrow(() -> new NotFoundException("Player was not found"));
    }

    public Player addPlayer(Player player) {
        if (playerRepository.findByName(player.getName()).isPresent()) {
            throw new DuplicationException("Player with name " + player.getName() + " already exists");
        }

        return playerRepository.save(player);
    }

    public PlayerStatistics getPlayerStatistics(Integer playerId) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new NotFoundException("Player was not found"));
        List<Event> playerEvents = eventRepository.findByPlayerId(playerId);

        Map<EventType, Long> eventCounts = playerEvents.stream().collect(Collectors.groupingBy(Event::getType,
                Collectors.counting()));

        return new PlayerStatistics(player.getName(), eventCounts);
    }
}
