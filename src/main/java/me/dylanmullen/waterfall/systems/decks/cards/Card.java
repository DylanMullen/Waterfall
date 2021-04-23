package me.dylanmullen.waterfall.systems.decks.cards;

public class Card
{

	private CardSuit suit;
	private CardFace face;

	public Card(CardSuit suit, int number)
	{
		this.suit = suit;
		this.face = CardFace.getFace(number);
	}

	public CardSuit getSuit()
	{
		return suit;
	}
	
	public CardFace getFace()
	{
		return face;
	}

}
