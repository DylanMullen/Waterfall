package me.dylanmullen.waterfall.web.controllers;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserRESTController
{
	
	@GetMapping("/{uuid}")
	public String getUser(@PathVariable("uuid") UUID uuid)
	{
		return "test";
	}

}
