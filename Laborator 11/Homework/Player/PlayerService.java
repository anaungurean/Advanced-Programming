package com.example.demo.Player;

import com.example.demo.Exceptions.PlayerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers(){
        return playerRepository.findAll();
    }

    public void addNewPlayer(Player player) {
        playerRepository.save(player);

    }

    public void updatePlayerName(Long playerId, String name) {
        Player player = getPlayerById(playerId);
        if (player != null) {
            player.setName(name);
            playerRepository.save(player);

        } else {
            throw new PlayerNotFoundException("Player with ID " + playerId + " not found.");
        }
    }

    private Player getPlayerById(Long playerId) {

        return playerRepository.findById(playerId).orElse(null);
    }


    public void deletePlayer(Long playerId) {
        Player player = getPlayerById(playerId);
        if (player != null) {
             playerRepository.delete(player);
        } else {
            throw new PlayerNotFoundException("Player with ID " + playerId + " not found.");
        }
    }
}
