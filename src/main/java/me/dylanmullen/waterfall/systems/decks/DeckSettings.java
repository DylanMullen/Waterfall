package me.dylanmullen.waterfall.systems.decks;

import me.dylanmullen.waterfall.configs.Config;

public class DeckSettings
{

	private DeckType deckType;
	private CardChallenges challenges;

	private boolean includeJokers;

	public DeckSettings(DeckType type, Config config)
	{
		this.deckType = type;
		this.challenges = new CardChallenges(config);
	}

	public DeckType getDeckType()
	{
		return deckType;
	}

	public CardChallenges getChallenges()
	{
		return challenges;
	}

}
