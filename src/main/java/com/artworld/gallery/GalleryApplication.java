package com.artworld.gallery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.artworld.gallery.domain.ArtRepository;
import com.artworld.gallery.domain.Art;

//This is the class is where the whole entity of the application starts!
//This was generated automatically by the Spring initializer web app, with some 
//additional modification


@SpringBootApplication
public class GalleryApplication {
	
	//The art repository is injected here to provide the needed CRUD functions.
	//This annotation below permits DI, dependency injection, which passes
	//dependencies into a generated art object
	@Autowired
	private ArtRepository artRep;
	
	private static final Logger log = LoggerFactory.getLogger(GalleryApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(GalleryApplication.class, args);
		log.info("Good morning/evening!");
	}

//This is an interface that permits additional code executions, including test data, before the
//application is fully launched.
//The same objects will be created for testing each time the app launches or restarts, thus
//all attempted data modifications via the controller methods aren't permanent
	@Bean
	public CommandLineRunner data(ArtRepository artRep) {
		return args -> {
			artRep.save(new Art("At Eternity's Gate",1890));
			artRep.save(new Art("The Son of Man",1964));
			artRep.save(new Art("Oath of the Horatii",1784));
		};
	}
}
