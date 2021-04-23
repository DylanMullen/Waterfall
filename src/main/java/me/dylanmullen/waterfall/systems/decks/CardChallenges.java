package me.dylanmullen.waterfall.systems.decks;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONObject;

import me.dylanmullen.waterfall.configs.Config;
import me.dylanmullen.waterfall.configs.ConfigController;
import me.dylanmullen.waterfall.systems.decks.cards.CardFace;

public class CardChallenges
{

	private Map<Integer, String> faceChallenges;

	private String redChallenge;
	private String blackChallenge;

	public CardChallenges()
	{
		this(ConfigController.getInstance().getConfig("default-card"));
	}

	public CardChallenges(Config config)
	{
		this.faceChallenges = new HashMap<>();
		init(config);
	}

	@SuppressWarnings("unchecked")
	private void init(Config config)
	{
		JSONObject challenges = config.getJSONObject("challenges");
		for (JSONObject card : (Set<JSONObject>) ((JSONObject) challenges.get("cards")).keySet())
			faceChallenges.put((int) card.get("id"), (String) card.get("challenge"));

		setColourChallenge((JSONObject) challenges.get("colour"), 0);
		setColourChallenge((JSONObject) challenges.get("colour"), 1);
	}

	private void setColourChallenge(JSONObject challenges, int colour)
	{
		if (colour == 0)
			this.redChallenge = (String) challenges.get("red");
		else
			this.blackChallenge = (String) challenges.get("black");
	}

	public String getRedChallenge()
	{
		return redChallenge;
	}

	public String getBlackChallenge()
	{
		return blackChallenge;
	}

	public String getChallenge(CardFace face)
	{
		return faceChallenges.get(face.getFaceCode());
	}

}
