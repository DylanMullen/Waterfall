package me.dylanmullen.waterfall.systems.decks.cards;

public enum CardSuit
{

	HEART(0), CLUB(1), DIAMOND(2), SPADE(3);

	private int id;

	private CardSuit(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return id;
	}

	public static CardSuit getSuitById(int id)
	{
		for (CardSuit suit : CardSuit.values())
			if (suit.getId() == id)
				return suit;
		return null;
	}

}
