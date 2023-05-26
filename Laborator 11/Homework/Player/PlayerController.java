package com.example.demo.Player;

import com.example.demo.Player.Player;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Operation(summary = "Get all players", description = "Retrieve a list of all players")
    @GetMapping
    public List<Player> getPlayers(){
        return playerService.getPlayers();
    }

    @Operation(summary = "Create a new player", description = "Add a new player to the system")
    @PostMapping
    public void createPlayer(@RequestBody Player player) {
        playerService.addNewPlayer(player);
    }

    @Operation(summary = "Update player name", description = "Update the name of a player by their ID")
    @PutMapping("/{playerId}")
    public void updatePlayerName(@PathVariable Long playerId, @RequestBody Player updatedPlayer) {
        playerService.updatePlayerName(playerId, updatedPlayer.getName());
    }

    @Operation(summary = "Delete a player by ID", description = "Remove a player from the system by their ID")
    @DeleteMapping("/{playerId}")
    public void deletePlayer(@PathVariable Long playerId) {
        playerService.deletePlayer(playerId);
    }
}
