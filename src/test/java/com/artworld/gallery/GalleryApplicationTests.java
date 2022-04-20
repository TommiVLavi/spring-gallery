package com.artworld.gallery;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.artworld.gallery.web.ArtController;

//This is a JUnit-based test class, thus it has the "@SpringBootTest" annotation attached
//here. It's used for regular tests and for specific parts of the application.
//The "@ExtendWith" annotation allows JUnit to utilize Spring's testing support
@ExtendWith(SpringExtension.class)
@SpringBootTest
class GalleryApplicationTests {
	
	@Autowired
	private ArtController cont;
	
	//And this method, labeled with an annotation below, is a single test case.
	//Each such case will be shown separately telling about operability
	//of each tested function.
	
	//The first one is a basic checking that the controller instance was
	//properly created and injected
	@Test
	void contextLoads() {
		assertThat(cont).isNotNull();
	}
}
