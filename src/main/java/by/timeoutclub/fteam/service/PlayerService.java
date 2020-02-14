package by.timeoutclub.fteam.service;

import by.timeoutclub.fteam.dao.PlayerRepository;
import by.timeoutclub.fteam.exception.DuplicationException;
import by.timeoutclub.fteam.exception.NotFoundException;
import by.timeoutclub.fteam.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
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
}
