package me.dylanmullen.waterfall.systems.decks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.dylanmullen.waterfall.systems.decks.cards.Card;
import me.dylanmullen.waterfall.systems.decks.cards.CardSuit;

public class Deck
{

	private DeckSettings settings;

	private List<Card> cards;
	private Random random;

	public Deck(DeckSettings settings)
	{
		this.settings = settings;
		this.cards = new ArrayList<Card>();
		this.random = new Random();
		init();
	}

	private void init()
	{
		createCards();
	}

	private void createCards()
	{
		CardSuit currentSuit = CardSuit.HEART;
		DeckType type = settings.getDeckType();

		int cardId = 0;
		for (int i = 0; i < (type.getDecks() * 13) - 1; i++)
		{
			cards.add(new Card(currentSuit, cardId));
			if (i % 13 == 0 && i != 0)
			{
				cardId = 0;
				currentSuit = CardSuit.getSuitById(currentSuit.getId());
			}
			cardId++;
		}

		if (settings.hasIncludedJokers())
		{
			cards.add(new Card(CardSuit.DIAMOND, 13));
			cards.add(new Card(CardSuit.CLUB, 13));
		}
	}

	public Card pickCard()
	{
		if (cards.size() == 0)
			return null;
		
		int cardID = random.nextInt(cards.size());
		Card card = cards.get(cardID);
		cards.remove(cardID);
		return card;
	}

	public DeckSettings getSettings()
	{
		return settings;
	}

}
