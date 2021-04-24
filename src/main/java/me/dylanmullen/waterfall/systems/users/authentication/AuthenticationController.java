package me.dylanmullen.waterfall.systems.users.authentication;

import java.sql.SQLException;
import java.util.UUID;

import org.json.simple.JSONObject;

import me.dylanmullen.waterfall.configs.Config;
import me.dylanmullen.waterfall.configs.ConfigController;
import me.dylanmullen.waterfall.mysql.SQLFactory;
import me.dylanmullen.waterfall.mysql.callbacks.SQLCallback;
import me.dylanmullen.waterfall.systems.users.UserController;
import me.dylanmullen.waterfall.util.DiscordOAuth;

public class AuthenticationController
{

	private static AuthenticationController instance;

	private Config credentials;
	private String clientID;
	private String clientSecret;

	public AuthenticationController()
	{
		if (instance == null)
			instance = this;

		this.credentials = ConfigController.getInstance().getConfig("credentials");
		this.clientID = (String) credentials.getValue("security.discord", "client-id");
		this.clientSecret = (String) credentials.getValue("security.discord", "client-secret");
	}

	public static AuthenticationController getInstance()
	{
		if (instance == null)
			new AuthenticationController();
		return instance;
	}

	public long authenticateToken(String authtoken)
	{
		JSONObject auth = DiscordOAuth.sendAuthPost(clientID, clientSecret, authtoken);
		JSONObject user = DiscordOAuth.sendUserGet((String) auth.get("access_token"));

		SQLFactory.sendTicket(SQLFactory.selectData("users", "*", new String[]
		{
				"discord-id"
		}, new String[]
		{
				(String) user.get("id")
		}, new SQLCallback()
		{
			@Override
			public boolean callback()
			{
				try
				{
					if (getResult().next())

						UserController.getInstance().loadUser(UUID.fromString(getResult().getString("uuid")),
								getResult().getString("username"), getResult().getLong("discord-id"));
					else
						UserController.getInstance().createUser((String) user.get("username"),
								(String) user.get("email"), (long) user.get("id"));
				} catch (SQLException e)
				{
				}
				return false;
			}
		}));
		return (long) user.get("id");
	}

}
