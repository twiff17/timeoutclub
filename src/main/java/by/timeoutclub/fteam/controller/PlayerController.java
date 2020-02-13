package by.timeoutclub.fteam.controller;

import by.timeoutclub.fteam.model.Player;
import by.timeoutclub.fteam.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    @ResponseBody
    public List<Player> getPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Player getPlayers(@PathVariable("id") Integer playerId) {
        return playerService.getPlayerById(playerId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Player addPlayer(@Valid @RequestBody Player player) {
        return playerService.addPlayer(player);
    }
}
