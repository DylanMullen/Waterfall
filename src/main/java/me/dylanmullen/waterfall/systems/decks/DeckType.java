package me.dylanmullen.waterfall.systems.decks;

public enum DeckType
{

	FULL_SET(4), SINGLE_SUIT(1), DOUBLE_SUIT(2);

	private int decks;

	private DeckType(int decks)
	{
		this.decks = decks;
	}

	public int getDecks()
	{
		return decks;
	}
}
