package com.artworld.gallery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class GalleryApplication {
	
	private static final Logger log = LoggerFactory.getLogger(GalleryApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(GalleryApplication.class, args);
		log.info("Good morning/evening!");
	}

}
