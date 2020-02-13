package by.timeoutclub.fteam.controller;

import by.timeoutclub.fteam.dao.GameRepository;
import by.timeoutclub.fteam.exception.NotFoundException;
import by.timeoutclub.fteam.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("games")
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @GetMapping
    @ResponseBody
    public List<Game> getGames() {
        return gameRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Game getGame(@PathVariable("id") Integer gameId) {
        Game game = gameRepository.findById(gameId).orElseThrow(() -> new NotFoundException("Game was not found"));
        game.add(linkTo(methodOn(GameController.class).getGame(gameId)).withSelfRel());
        return game;
    }
}
