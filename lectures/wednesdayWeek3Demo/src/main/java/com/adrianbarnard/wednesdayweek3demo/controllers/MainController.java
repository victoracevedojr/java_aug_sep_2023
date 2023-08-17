package com.adrianbarnard.wednesdayweek3demo.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // Make sure you import the correct Model!!
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller // This will allow us to serve not just raw data, but .jsp files as well
public class MainController {
	@GetMapping("/")
	public String homePage() {
		return "main.jsp";
	}
	
	// The Model below is a container for holding the data we'll send along with our JSP file
	@GetMapping("/pokemon/{name}")
	public String pokemonPage(Model viewModel, @PathVariable("name") String name) {
		// Adding an attribute to the container - note the "key", value pairing below in the parentheses
		viewModel.addAttribute("favoritePokemon", name);
		return "pokemon.jsp";
	}
	
	@GetMapping("/pokemonlist")
	public String listOfPokemonPage(Model model) {
		ArrayList<String> favoritePokemon = new ArrayList<String>();
		favoritePokemon.add("Gyarados");
		favoritePokemon.add("Scyther");
		favoritePokemon.add("Charmander");
		favoritePokemon.add("Ampharos");
		model.addAttribute("favPokemon", favoritePokemon);
		return "list.jsp";
	}
}
