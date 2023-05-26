package com.example.demo;

import com.example.demo.Game.Game;
import com.example.demo.Player.Player;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = {"com.example.demo", "com.example.demo.Player","com.example.demo.Game"})
@SpringBootApplication
@OpenAPIDefinition

public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	public static void main(String[] args) {
//		ConfigurableApplicationContext context =  	SpringApplication.run(DemoApplication.class, args);
//
// 		RestTemplate restTemplate = new RestTemplate();
//
// 		invokeGetGames(restTemplate);
////		invokeCreateGame(restTemplate);
////		invokeDeleteGame(restTemplate);
//
////		invokeGetPlayers(restTemplate);
////		invokeCreatePlayer(restTemplate);
////		invokeUpdatePlayerName(restTemplate);
////		invokeDeletePlayer(restTemplate);
//
//		context.close();
//	}

	private static void invokeGetGames(RestTemplate restTemplate) {
		String url = "http://localhost:8085/games";
		Game[] games = restTemplate.getForObject(url, Game[].class);
		System.out.println("Get Games Response:");
		for (Game game : games) {
			System.out.println(game);
		}
		System.out.println();
	}

	private static void invokeCreateGame(RestTemplate restTemplate) {
		String url = "http://localhost:8085/games";
		Game game = new Game(1L, 2L, 2L);
		restTemplate.postForObject(url, game, Void.class);
		System.out.println("Create Game Request: Game created successfully");
		System.out.println();
	}

	private static void invokeDeleteGame(RestTemplate restTemplate) {
		String url = "http://localhost:8085/games/{gameId}";
		restTemplate.delete(url, 1L);
		System.out.println("Delete Game Request: Game deleted successfully");
		System.out.println();
	}

	private static void invokeGetPlayers(RestTemplate restTemplate) {
		String url = "http://localhost:8085/players";
		Player[] players = restTemplate.getForObject(url, Player[].class);
		System.out.println("Get Players Response:");
		for (Player player : players) {
			System.out.println(player);
		}
		System.out.println();
	}

	private static void invokeCreatePlayer(RestTemplate restTemplate) {
		String url = "http://localhost:8085/players";
		Player player = new Player("Ion");
		restTemplate.postForObject(url, player, Void.class);
		System.out.println("Create Player Request: Player created successfully");
		System.out.println();
	}

	private static void invokeUpdatePlayerName(RestTemplate restTemplate) {
		String url = "http://localhost:8085/players/{playerId}";
		Player updatedPlayer = new Player("Marian");
		restTemplate.put(url, updatedPlayer, 25L);
		System.out.println("Update Player Name Request: Player name updated successfully");
		System.out.println();
	}

	private static void invokeDeletePlayer(RestTemplate restTemplate) {
		String url = "http://localhost:8085/players/{playerId}";
		restTemplate.delete(url, 25L);
		System.out.println("Delete Player Request: Player deleted successfully");
		System.out.println();
	}
}
