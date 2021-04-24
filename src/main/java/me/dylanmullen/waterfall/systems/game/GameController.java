package me.dylanmullen.waterfall.systems.game;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import me.dylanmullen.waterfall.systems.users.User;

public class GameController
{

	private static GameController instance;

	private List<WaterfallGame> games;

	public GameController()
	{
		if (instance == null)
			instance = this;

		this.games = new ArrayList<>();
	}

	public void createGame(User user)
	{
		games.add(new WaterfallGame(user));
	}

	public WaterfallGame getGame(UUID uuid)
	{
		for (WaterfallGame game : games)
			if (game.getGameUUID().equals(uuid))
				return game;
		return null;
	}

	public static GameController getInstance()
	{
		if (instance == null)
			new GameController();

		return instance;
	}

}
