package com.example.demo.Game;

import com.example.demo.Exceptions.PlayerNotFoundException;
import com.example.demo.Player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository){
        this.gameRepository=gameRepository;
    }

    public List<Game> getGames(){
        return gameRepository.findAll();
    }

    public void addNewGame(Game game){
        gameRepository.save(game);
    }

    public void deleteGame(Long gameId) {
        Game game = getGames(gameId);
        if (game != null) {
            gameRepository.delete(game);
        } else {
            throw new PlayerNotFoundException("Game with ID " + gameId + " not found.");
        }
    }

    private Game getGames(Long gameId) {
        return gameRepository.findById(gameId).orElse(null);
    }


}
