package me.dylanmullen.waterfall.web.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.dylanmullen.waterfall.systems.users.authentication.AuthenticationController;

@RestController
@RequestMapping("/auth")
public class AuthRESTController
{

	@GetMapping("/discord/login")
	public void discordLogin(HttpServletResponse res, @RequestParam("code") String code) throws IOException
	{
		long id = AuthenticationController.getInstance().authenticateToken(code);
		String redirectUrl = "../../../?discord-id=" + id;
		res.setHeader("Location", redirectUrl);
		res.setStatus(302);
	}
}
