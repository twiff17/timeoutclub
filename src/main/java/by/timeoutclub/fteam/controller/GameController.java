package by.timeoutclub.fteam.controller;

import by.timeoutclub.fteam.model.dto.EventDTO;
import by.timeoutclub.fteam.model.entity.Event;
import by.timeoutclub.fteam.model.entity.Game;
import by.timeoutclub.fteam.service.GameService;
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

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<Game> getGames() {
        return gameService.getGames();
    }

    @GetMapping("/{gameId}")
    public Game getGame(@PathVariable Integer gameId) {
        Game game = gameService.getGameById(gameId);
        game.add(linkTo(methodOn(GameController.class).getGame(gameId)).withSelfRel());
        return game;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Game addGame(@RequestBody @Valid Game game){
        return gameService.addGame(game);
    }

    @PostMapping("/{gameId}/events")
    @ResponseStatus(HttpStatus.CREATED)
    public Event addEvent(@RequestBody @Valid EventDTO event, @PathVariable Integer gameId) {
        return gameService.addEvent(event, gameId);
    }
}
