package com.artworld.gallery.domain;

public class Art {
	
	private Long id;
	
	private String name;
	
	private int year;

	
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getYear() {
		return year;
	}

	
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setYear(int year) {
		this.year = year;
	}
}
