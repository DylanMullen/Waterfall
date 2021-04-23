package me.dylanmullen.waterfall.systems.decks;

public enum DeckType
{

	FULL_SET(4, 0), SINGLE_SUIT(1, 1), DOUBLE_SUIT(2, 2);

	private int decks;
	private int id;

	private DeckType(int decks, int id)
	{
		this.decks = decks;
		this.id = id;
	}

	public int getDecks()
	{
		return decks;
	}

	public int getId()
	{
		return id;
	}

	public static DeckType getType(int id)
	{
		for (DeckType type : DeckType.values())
			if (type.getId() == id)
				return type;
		return null;
	}
}
