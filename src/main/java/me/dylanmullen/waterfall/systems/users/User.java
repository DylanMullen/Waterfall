package me.dylanmullen.waterfall.systems.users;

import java.util.UUID;

public class User
{

	private UUID uuid;
	private String name;
	private long discordID;
	
	public User(UUID uuid, String name, long discordID)
	{
		this.uuid=uuid;
		this.name = name;
		this.discordID=discordID;
	}
	
	public UUID getUuid()
	{
		return uuid;
	}

	public String getName()
	{
		return name;
	}
	
	public long getDiscordID()
	{
		return discordID;
	}

}
