package me.dylanmullen.waterfall.systems.decks;

import me.dylanmullen.waterfall.configs.Config;
import me.dylanmullen.waterfall.systems.decks.cards.challenges.CardChallenges;

public class DeckSettings
{

	private DeckType deckType;
	private CardChallenges challenges;

	private boolean includeJokers;

	public DeckSettings(Config config)
	{
		this.challenges = new CardChallenges(config);
		init(config);
	}

	private void init(Config config)
	{
		this.deckType = DeckType.getType((int) config.getValue("settings", "deck-type"));
		this.includeJokers = (boolean) config.getValue("settings", "include-jokers");
	}

	public DeckType getDeckType()
	{
		return deckType;
	}

	public CardChallenges getChallenges()
	{
		return challenges;
	}

	public boolean hasIncludedJokers()
	{
		return includeJokers;
	}

}
