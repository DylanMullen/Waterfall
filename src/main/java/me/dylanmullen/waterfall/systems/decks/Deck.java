package me.dylanmullen.waterfall.systems.decks;

import java.util.ArrayList;
import java.util.List;

import me.dylanmullen.waterfall.systems.decks.cards.Card;

public class Deck
{

	private DeckSettings settings;

	private List<Card> cards;
	
	public Deck(DeckSettings settings)
	{
		this.settings = settings;
		this.cards=new ArrayList<Card>();
		init();
	}
	
	private void init()
	{
		
	}
	
	
	public DeckSettings getSettings()
	{
		return settings;
	}

}
