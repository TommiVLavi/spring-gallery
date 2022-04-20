package com.artworld.gallery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.artworld.gallery.domain.ArtRepository;
import com.artworld.gallery.domain.Artist;
import com.artworld.gallery.domain.ArtistRepository;
import com.artworld.gallery.domain.Medium;
import com.artworld.gallery.domain.MediumRepository;
import com.artworld.gallery.domain.UserRepository;
import com.artworld.gallery.domain.Art;
import com.artworld.gallery.domain.User;

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
	public CommandLineRunner data(ArtRepository artRep, UserRepository usrRep, MediumRepository medRep, 
			ArtistRepository artistRep) {
		return args -> {
			artistRep.save(new Artist("Vincent","Van Gogh"));
			artistRep.save(new Artist("Jacques","David"));
			artistRep.save(new Artist("Rene","Margritte"));
			
			medRep.save(new Medium("Oil"));
			medRep.save(new Medium("Aquarelle"));
			medRep.save(new Medium("Gouache"));
			medRep.save(new Medium("Pastell"));
			medRep.save(new Medium("Color Pencils"));
			
			artRep.save(new Art("At Eternity's Gate", artistRep.findByFirstName("Vincent").get(0),
					1890, medRep.findByName("Oil").get(0)));
			
			artRep.save(new Art("The Son of Man", artistRep.findByFirstName("Jacques").get(0),
					1964, medRep.findByName("Oil").get(0)));
			
			artRep.save(new Art("Oath of the Horatii", artistRep.findByFirstName("Rene").get(0),
					1784, medRep.findByName("Oil").get(0)));
			
			//1234
			usrRep.save(new User("Tommi","$2y$08$v29bV81VMd3cueR3Fj/2yeSmV/eYiBBNoYg9HCz6TDLdJaINLohcq","ADMIN"));
			//4321
			usrRep.save(new User("Helena","$2y$08$vnCdSbeV.jtd6AF.knoyruiIgDMalrUpSZI5e59IJ3iwk1P.qrNtO","ADMIN"));
		};
	}
}
