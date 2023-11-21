package com.soulmc.redirect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.soulmc.redirect.utils.Utils;
import com.soulmc.redirect.utils.config.YamlConfig;
import lombok.Getter;

import java.util.List;

@SpringBootApplication
public class Application {

	@Getter
	private static YamlConfig config;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		Utils.saveResource("config.yml");
		Application.config = new YamlConfig("config.yml");
		RedirectManager.loadAll();
	}
	
	public static List<Redirect> getRedirects() {
		return List.of(
			new Redirect("discord", "https://discord.gg/PHJZYYawVV"),
			new Redirect("vk", "https://vk.com/soullandsbe/")
		);
	}
}
