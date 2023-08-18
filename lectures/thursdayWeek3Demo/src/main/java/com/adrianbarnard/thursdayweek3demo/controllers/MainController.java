package com.adrianbarnard.thursdayweek3demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	@GetMapping("/")
	public String formPage() {
		return "form.jsp";
	}
	
	@PostMapping("/processform")
	public String processFormRoute(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("favoriteNumber") String number,
			@RequestParam("info") String info,
			HttpSession session) {
		// Saving our form values in session to make them available elsewhere in our application
		session.setAttribute("firstName", firstName);
		session.setAttribute("lastName", lastName);
		session.setAttribute("favoriteNumber", number);
		session.setAttribute("info", info);
		
		return "redirect:/results"; // To redirect, type "redirect:/routeName", where "/routeName" is where you want to go
	}
	
	@GetMapping("/results")
	public String resultsPage(HttpSession session, Model viewModel) {
		// You MUST typecast when grabbing values from session because they come back as Objects
		viewModel.addAttribute("firstName", (String) session.getAttribute("firstName"));
		viewModel.addAttribute("lastName", (String) session.getAttribute("lastName"));
		// Saving the number as an Integer (wrapper class)
		viewModel.addAttribute("favoriteNumber", Integer.valueOf((String) session.getAttribute("favoriteNumber")));
		viewModel.addAttribute("info", (String) session.getAttribute("info"));
		return "results.jsp";
	}
}
