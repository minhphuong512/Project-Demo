package com.asm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
public class TilesConfig {
	
	@Bean("viewsResolver")
	public ViewResolver getViewResolver() {
		UrlBasedViewResolver viewsResolver = new UrlBasedViewResolver();
		viewsResolver.setViewClass(TilesView.class);
		return viewsResolver;
	}
	
	@Bean("tilesConfigurer")
	public TilesConfigurer getTilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions("/tiles.xml");
		return tilesConfigurer;
	}
}
