package com.example.demo.Game;

import com.example.demo.Player.Player;
import io.swagger.v3.oas.annotations.Operation;
import jdk.jfr.Description;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }


    @GetMapping
    @Operation(summary = "Get all games", description = "Retrieve a list of all games")
    public List<Game> getGames(){
        return gameService.getGames();
    }
    @Operation(summary = "Create a new game", description = "Add a new game to the system")
    @PostMapping
    public void createGame(@RequestBody Game game) {
        gameService.addNewGame(game);
    }

    @Operation(summary = "Delete a game by ID", description = "Remove a game from the system by its ID")
    @DeleteMapping("/{gameId}")
    public void deleteGame(@PathVariable Long gameId) {
        gameService.deleteGame(gameId);
    }

}
