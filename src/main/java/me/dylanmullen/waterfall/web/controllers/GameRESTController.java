package me.dylanmullen.waterfall.web.controllers;

import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.dylanmullen.waterfall.systems.decks.cards.Card;
import me.dylanmullen.waterfall.systems.game.GameController;
import me.dylanmullen.waterfall.systems.game.WaterfallGame;
import me.dylanmullen.waterfall.systems.users.User;
import me.dylanmullen.waterfall.systems.users.UserController;

@RestController
@RequestMapping("/game")
public class GameRESTController
{

	@PostMapping()
	public void createGame(@RequestParam("owner") UUID uuid, @RequestParam("deck") UUID deckSettings)
	{
		User user = UserController.getInstance().getUser(uuid);
		GameController.getInstance().createGame(user);
	}

	@PostMapping("/{game}/join")
	public UUID joinGame(@PathVariable("game") UUID gameUUID, @RequestParam("user") UUID userUUID)
	{
		WaterfallGame game = GameController.getInstance().getGame(gameUUID);
		game.addUser(UserController.getInstance().getUser(userUUID));
		return game.getGameUUID();
	}
}
