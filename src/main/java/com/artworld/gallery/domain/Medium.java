package com.artworld.gallery.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Medium {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long mediumid;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "medium")
	private List<Art> paintings;
	
	
	@Column(nullable = false)
	private String name;
	
	
	public Medium() {
		super();
	}
	
	public Medium(String name) {
		super();
		this.name = name;
	}


	public Long getMediumid() {
		return mediumid;
	}


	public List<Art> getPaintings() {
		return paintings;
	}


	public String getName() {
		return name;
	}


	public void setMediumid(Long mediumid) {
		this.mediumid = mediumid;
	}


	public void setPaintings(List<Art> paintings) {
		this.paintings = paintings;
	}


	public void setName(String name) {
		this.name = name;
	}
}
