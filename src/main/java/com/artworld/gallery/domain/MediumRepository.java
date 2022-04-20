package com.artworld.gallery.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MediumRepository extends CrudRepository <Medium, Long>{
	List<Medium> findByName(String name);
}
