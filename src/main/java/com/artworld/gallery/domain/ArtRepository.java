package com.artworld.gallery.domain;


import org.springframework.data.repository.CrudRepository;

//This class is an interface based of a pre-existing CRUD Repository class 
//from JPA Spring Framework,
//including some basic, predefined methods, such as "findById()".
// The two arguments in brackets are the entity class and the type of its
// ID field
public interface ArtRepository extends CrudRepository<Art, Long> {
	
}
