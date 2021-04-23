package me.dylanmullen.waterfall.systems.decks;

import java.util.ArrayList;
import java.util.List;

import me.dylanmullen.waterfall.systems.decks.cards.Card;
import me.dylanmullen.waterfall.systems.decks.cards.CardSuit;

public class Deck
{

	private DeckSettings settings;

	private List<Card> cards;

	public Deck(DeckSettings settings)
	{
		this.settings = settings;
		this.cards = new ArrayList<Card>();
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
		
		if(type == DeckType.FULL_SET_JOKERS)
		{
			
		}
			
	}

	public DeckSettings getSettings()
	{
		return settings;
	}

}
