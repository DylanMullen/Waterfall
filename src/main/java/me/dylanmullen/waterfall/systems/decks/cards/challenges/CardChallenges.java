package me.dylanmullen.waterfall.systems.decks.cards.challenges;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.json.simple.JSONObject;

import me.dylanmullen.waterfall.configs.Config;
import me.dylanmullen.waterfall.systems.decks.cards.CardFace;

public class CardChallenges
{

	private String name;
	private UUID uuid;

	private Map<Integer, String> faceChallenges;
	private String redChallenge;
	private String blackChallenge;

	public CardChallenges(Config config)
	{
		this.faceChallenges = new HashMap<>();
		init(config);
	}

	private void init(Config config)
	{
		setSettings(config);
		setupChallenges(config);
	}

	private void setSettings(Config config)
	{
		JSONObject settings = config.getJSONObject("settings");
		this.name = (String) settings.get("name");
		this.uuid = UUID.fromString((String) settings.get("uuid"));
	}

	@SuppressWarnings("unchecked")
	private void setupChallenges(Config config)
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
	
	public String getName()
	{
		return name;
	}
	
	public UUID getUUID()
	{
		return uuid;
	}

}
