package me.dylanmullen.waterfall.systems.decks.cards;

public enum CardFace
{

	ACE("Ace", 0), TWO("Two", 1), THREE("Three", 2), FOUR("Four", 3), FIVE("Five", 4), SIX("Six", 5), SEVEN("Seven", 6),
	EIGHT("Eight", 7), NINE("Nine", 8), TEN("Ten", 9), JACK("Jack", 10), QUEEN("Queen", 11), KING("King", 12),
	JOKER("Joker", 13);

	private String name;
	private int faceCode;

	private CardFace(String name, int faceCode)
	{
		this.name = name;
		this.faceCode = faceCode;
	}

	public int getFaceCode()
	{
		return faceCode;
	}

	public String getName()
	{
		return name;
	}

	public static CardFace getFace(int faceCode)
	{
		for (CardFace face : CardFace.values())
			if (face.getFaceCode() == faceCode)
				return face;
		return null;
	}
}
