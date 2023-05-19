package org.example;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GameManager {
    private static List<Game> games = new CopyOnWriteArrayList<>();
    private GameManager() {
    }
    public static Game createGame(){
        Game game= new Game();
        games.add(game);
        return game;
    }
    public static void addGame(Game game){
        games.add(game);
    }
    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
    public static Game getGameWithSinglePlayer() {
        for (Game game : games) {
            if (game.getPlayers().size() == 1) {
                return game;
            }
        }
        return null;
    }

}
