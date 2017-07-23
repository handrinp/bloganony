package com.bloganony;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class SpringConfig extends WebMvcConfigurerAdapter {
	private static Map<String, String> reg;

	static {
		reg = new HashMap<>();
		reg.put("/home", "home");
		reg.put("/", "home");
		reg.put("/admin", "admin");
		reg.put("/login", "login");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		reg.values().forEach(key -> {
			registry.addViewController(key).setViewName(reg.get(key));
		});
	}
}
