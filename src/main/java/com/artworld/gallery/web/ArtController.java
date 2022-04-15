package com.artworld.gallery.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.artworld.gallery.domain.ArtRepository;

@Controller
public class ArtController {
	
	//The art repository is injected here to provide the needed CRUD functions.
	//This annotation below permits DI, dependency injection, which passes
	//repository dependencies into this class
	@Autowired
	private ArtRepository artRep;
	
	
	//This controller leads to a main room with a full list of all
	//the saved paintings in the database
	//It simultaneously fetches all the data via "findAll()" CRUD method
	// and labels this garnered stack with "paintings" term.
	// Then the Thymeleaf index template, as a view in MVC, picks up and 
	//visually presents that labelled stack of
	// data, as it has ${paintings} designated onto its table.
	@RequestMapping(value = {"/","/lobby"})
	public String lobby(Model model) {
		model.addAttribute("paintings", artRep.findAll());
		return "index";
	}
	
	
}
