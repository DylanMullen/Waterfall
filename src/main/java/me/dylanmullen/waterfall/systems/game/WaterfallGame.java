package me.dylanmullen.waterfall.systems.game;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import me.dylanmullen.waterfall.systems.decks.Deck;
import me.dylanmullen.waterfall.systems.decks.DeckSettings;
import me.dylanmullen.waterfall.systems.decks.cards.Card;
import me.dylanmullen.waterfall.systems.users.User;

public class WaterfallGame
{

	private UUID gameUUID;

	private User owner;
	private List<User> users;

	private int currentPlayer;
	private Deck cardDeck;

	public WaterfallGame(User user, DeckSettings settings)
	{
		this.owner = user;
		this.gameUUID = UUID.randomUUID();
		this.users = new ArrayList<>();
		this.cardDeck = new Deck(settings);
	}

	public WaterfallGame(User user)
	{
		this(user, new DeckSettings());
	}

	public void addUser(User user)
	{
		if (users.contains(user))
			return;
		users.add(user);
	}

	public void removeUser(User user)
	{
		if (!users.contains(user))
			return;

		users.remove(user);
	}

	public Card nextCard(User user)
	{
		if (users.get(currentPlayer).equals(user))
			return null;
		
		Card card = cardDeck.pickCard();
		currentPlayer = (currentPlayer + 1 > users.size() ? 0 : currentPlayer + 1);
		return card;
	}

	public User getOwner()
	{
		return owner;
	}

	public UUID getGameUUID()
	{
		return gameUUID;
	}

	public Deck getCardDeck()
	{
		return cardDeck;
	}

	public List<User> getUsers()
	{
		return users;
	}

}
