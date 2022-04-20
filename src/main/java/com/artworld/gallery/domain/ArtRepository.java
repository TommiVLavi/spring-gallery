package com.artworld.gallery.domain;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

//This class is an interface based of a pre-existing CRUD Repository class 
//from JPA Spring Framework,
//including some basic, predefined methods, such as "findById()".
// The two arguments in brackets are the entity class and the type of its
// ID field
public interface ArtRepository extends CrudRepository<Art, Long> {
	
	//And this is a custom, programmer-added method that seeks
	// for a specific object based on its name from the database.
	List<Art> findByName(String name);
}
