package com.artworld.gallery.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.artworld.gallery.domain.ArtRepository;
import com.artworld.gallery.domain.Art;

@Controller
public class ArtController {
	
	//The art repository is injected here to provide the needed CRUD functions.
	//This annotation below permits DI, dependency injection, which passes
	//repository dependencies into this class
	@Autowired
	private ArtRepository artRep;
	
	//LOBBY
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
	
	//ADD
	//This one, on the other hand, after clicking on a link in the lobby template, 
	// leads to the "add" page and simultaneously prepares a new art object, with 
	//an empty constructor,
	//labeled for Thyme as "painting", before the user submits new data into it.
	@RequestMapping(value = "/add")
	public String add(Model model) {
		model.addAttribute("painting", new Art());
		return "add";
	}
	
	//SAVE
	// This is a separate method to save user-suggested data into the database,
	// thus using a POST method.
	// When clicking a submit button from the "add" template, it will lead
	// to the "/save" index
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Art art) {
		artRep.save(art);
		return "redirect:lobby";
	}
	
	//REMOVE
	// This one will delete a specific saved object based on an id
	// number that it extracts from a tip of an URL address via 
	//"@PathVariable" annotation. The list template generates links
	// for each data row that generate the URL numbers based on fetched
	// id numbers from objects
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String remove(@PathVariable("id")Long artId) {
		artRep.deleteById(artId);
		return "redirect:../lobby";
	}
	
	//EDIT
	// Very similar to the remove method, particularly with its id retrieving function, 
	//but also brings the user to an edit template and
	// permits an edit of an saved object, which will be retrieved from a repository
	// via findById CRUD method
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Long artId, Model model) {
		model.addAttribute("art", artRep.findById(artId));
		return "edit";
	}
	
	//LOGIN
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
}
