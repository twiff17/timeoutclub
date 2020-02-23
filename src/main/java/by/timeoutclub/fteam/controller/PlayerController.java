package by.timeoutclub.fteam.controller;

import by.timeoutclub.fteam.model.dto.PlayerStatistics;
import by.timeoutclub.fteam.model.entity.Player;
import by.timeoutclub.fteam.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public List<Player> getPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public Player getPlayerById(@PathVariable("id") Integer playerId) {
        return playerService.getPlayerById(playerId);
    }

    @GetMapping("/{id}/statistics")
    public PlayerStatistics getPlayerStatistics(@PathVariable("id") Integer playerId) {
        return playerService.getPlayerStatistics(playerId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Player addPlayer(@Valid @RequestBody Player player) {
        return playerService.addPlayer(player);
    }
}
