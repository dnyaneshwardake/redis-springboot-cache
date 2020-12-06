package com.dnyanesh.cache.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableCaching
@Slf4j
public class CacheConfig {

	/*
	 * Method will help to fetch cache from DB once Application is up
	 */
	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		log.info("Loading applocation cache::");
	}

}
