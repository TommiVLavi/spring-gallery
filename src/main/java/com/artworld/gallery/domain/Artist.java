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
public class Artist {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long artistid;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "artist")
	private List<Art> paintings;
	
	
	private String firstName;
	
	
	@Column(nullable = false)
	private String surName;
	

	public Artist(String firstName, String surName) {
		super();
		this.firstName = firstName;
		this.surName = surName;
	}

	public Artist() {
		super();
	}

	
	public Long getArtistid() {
		return artistid;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSurName() {
		return surName;
	}

	public List<Art> getPaintings() {
		return paintings;
	}

	public void setArtistid(Long artistid) {
		this.artistid = artistid;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public void setPaintings(List<Art> paintings) {
		this.paintings = paintings;
	}
}
