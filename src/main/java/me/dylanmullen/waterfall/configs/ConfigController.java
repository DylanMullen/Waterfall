package me.dylanmullen.waterfall.configs;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import me.dylanmullen.waterfall.core.Runner;

public class ConfigController
{

	private static ConfigController instance;

	private File configFolder;
	private List<Config> configs;

	public ConfigController()
	{
		if (instance == null)
			instance = this;

		try
		{
			this.configs = new ArrayList<Config>();
			this.configFolder = new File(
					ConfigController.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()
							+ File.separator + "configs");
			init();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static ConfigController getInstance()
	{
		if (instance == null)
			new ConfigController();

		return instance;
	}

	public boolean isFilesCopied()
	{
		return getConfigFolder().exists();
	}

	private void init()
	{
		if (!isFilesCopied())
			getConfigFolder().mkdirs();

		loadConfigs();
	}

	private void loadConfigs()
	{
		for (File file : getConfigFolder().listFiles())
			configs.add(new Config(file.getName().toLowerCase(), file));

		System.out.println(configs.size() + " Configs loaded.");
	}

	public Config getConfig(String name)
	{
		return getConfigs().stream().filter(e -> e.getName().equals(name + ".json")).findFirst().get();
	}

	public List<Config> getConfigs()
	{
		return configs;
	}

	public File getConfigFolder()
	{
		return configFolder;
	}

	private String getJARPath() throws UnsupportedEncodingException
	{
		String temp = URLDecoder.decode(Runner.class.getProtectionDomain().getCodeSource().getLocation().getFile(),
				"UTF-8");
		return new File(temp).getParentFile().getPath();
	}
}
