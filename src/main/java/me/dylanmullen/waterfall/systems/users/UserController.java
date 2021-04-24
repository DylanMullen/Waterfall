package me.dylanmullen.waterfall.systems.users;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import me.dylanmullen.waterfall.mysql.SQLFactory;

public class UserController
{

	private static UserController instance;

	private List<User> users;

	public UserController()
	{
		if (instance == null)
			instance = this;

		this.users = new ArrayList<User>();
	}

	public void createUser(String username, String email, long discordID)
	{
		sendUserCreationTicket(username, email, "", discordID);
	}

	private void sendUserCreationTicket(String username, String email, String password, long discordID)
	{
		SQLFactory.sendTicket(SQLFactory.insertData("users", new String[]
		{
				"uuid", "username", "email", "password", "discord-id"
		}, new String[]
		{
				UUID.randomUUID().toString(), username, email, password, "" + discordID
		}, null));
	}

	public void loadUser(UUID uuid, String name, long discordID)
	{
		if (getUser(uuid) != null)
			return;
		this.users.add(new User(uuid, name, discordID));
	}

	public User getUser(long discordID)
	{
		for (User user : users)
			if (user.getDiscordID() == discordID)
				return user;
		return null;
	}

	public User getUser(UUID uuid)
	{
		for (User user : users)
			if (user.getUuid().equals(uuid))
				return user;
		return null;
	}

	public static UserController getInstance()
	{
		return instance;
	}
	
	public List<User> getUsers()
	{
		return users;
	}

}
