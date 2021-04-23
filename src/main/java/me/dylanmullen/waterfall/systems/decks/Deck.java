package me.dylanmullen.waterfall.systems.decks;

public class Deck
{

	private DeckSettings settings;

	public Deck(DeckSettings settings)
	{
		this.settings = settings;
	}
	
	public DeckSettings getSettings()
	{
		return settings;
	}

}
