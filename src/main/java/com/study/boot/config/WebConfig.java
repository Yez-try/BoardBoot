package com.study.boot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class WebConfig implements WebMvcConfigurer{
	@Value("${my.url.path}")
	private String urlpath;
	@Value("${my.upload.base}")
	private String filepath;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		log.info("urlpath{}", urlpath);
		log.info("filepath{}", filepath);
		
		registry.addResourceHandler(urlpath)
				.addResourceLocations(filepath);
		
	}
	
}
