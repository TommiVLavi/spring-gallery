package com.artworld.gallery;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.artworld.gallery.domain.Art;
import com.artworld.gallery.domain.ArtRepository;
import com.artworld.gallery.domain.Artist;
import com.artworld.gallery.domain.ArtistRepository;
import com.artworld.gallery.domain.Medium;
import com.artworld.gallery.domain.MediumRepository;
import com.artworld.gallery.domain.User;

//This test class is dedicated to all the repositories and their CRUD functions, 
// thus having a different annotation

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class GalleryRepositoryTests {
	
	@Autowired
	private ArtRepository artRep;
	
	@Autowired
	private MediumRepository medRep;
	
	@Autowired
	private ArtistRepository artistRep;
	
	
	//ART
	//CREATE ART
	//Testing the save function of the Art Repository, as it needs to make sure
	//that it is created and the object has its id
	@Test
	public void createArt() {
		Art art = new Art("Testing", artistRep.findByFirstName("Vincent").get(0),
				1895, medRep.findByName("Aquarelle").get(0));
		artRep.save(art);
		assertThat(art.getId()).isNotNull();
	}
	
	//EDIT ART
	//This one is testing the ability to modify an object, as it makes
	// sure that the title modification is expected
	@Test
	public void editArt() {
		List <Art> art = artRep.findByName("The Son of Man");
		String test = "Something Else";
		art.get(0).setName(test);
		assertThat(art.get(0).getName()).isEqualTo(test);
	}
	
	//DELETE ART
	//This one makes sure that the specific object is deleted by checking
	// the searched object is not available
	@Test
	public void deleteArt() {
		String title = "Oath of the Horatii";
		List<Art> art = artRep.findByName(title);
		Long id = art.get(0).getId();
		artRep.deleteById(id);
		assertThat(artRep.findByName(title)).isEmpty();
	}
	
	
	//MEDIUM
	//CREATE MEDIUM
	@Test
	public void createMed() {
		String medName = "Test Paints";
		Medium medium = new Medium(medName);
		medRep.save(medium);
		String artName = "Test";
		artRep.save(new Art(artName,artistRep.findByFirstName("Vincent").get(0),1990,medRep.findByName(medName).get(0)));
		assertThat(artRep.findByName(artName).get(0).getMedium().getName()).isEqualTo(medName);
	}
}
