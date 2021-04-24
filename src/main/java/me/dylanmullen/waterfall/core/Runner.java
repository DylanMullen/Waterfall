package me.dylanmullen.waterfall.core;

import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import me.dylanmullen.waterfall.configs.ConfigController;
import me.dylanmullen.waterfall.web.WebServer;

@SpringBootApplication
public class Runner
{

	public static void main(String[] args)
	{
//		new WaterfallApp();
		System.out.println(UUID.randomUUID().toString());
		ConfigController.getInstance();
		SpringApplication.run(WebServer.class, args);
	}

}
