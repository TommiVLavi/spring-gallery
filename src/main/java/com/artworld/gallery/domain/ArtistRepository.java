package com.artworld.gallery.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository <Artist, Long>{
	List<Artist> findByFirstName(String firstName);
	
	List<Artist> findBySurName(String surName);
}
