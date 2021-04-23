package me.dylanmullen.waterfall.systems.decks.cards.challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import me.dylanmullen.waterfall.configs.Config;
import me.dylanmullen.waterfall.configs.ConfigController;

public class ChallengesController
{

	private List<CardChallenges> challenges;

	public ChallengesController()
	{
		this.challenges = new ArrayList<CardChallenges>();
		loadDefault();
	}

	public void createChallenge(CardChallenges challenge)
	{
		if (getChallenge(challenge.getName()) != null)
			return;
		
		challenges.add(challenge);
	}
	
	public void loadDefault()
	{
		createChallenge(new CardChallenges());
	}
	
	public void loadChallenge(UUID uuid)
	{
		Config config = ConfigController.getInstance().getConfig(uuid.toString());
		if(config == null)
			return;
		createChallenge(new CardChallenges(config));
	}

	public CardChallenges getChallenge(String name)
	{
		for (CardChallenges challenge : challenges)
			if (challenge.getName().equalsIgnoreCase(name))
				return challenge;
		return null;
	}

}
