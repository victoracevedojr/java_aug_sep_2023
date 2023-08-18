package com.adrianbarnard.cyoademo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CYOAController {
	@GetMapping("/") // Starting page before we begin the adventure
	public String homePage() {
		return "main.jsp";
	}
	
	@GetMapping("/play/{action}") // Path variable used to display message and options for us to take
	public String storyPage(@PathVariable("action") String action, Model viewModel) {
		String storyMessage, leftLink, rightLink;
		switch (action) { // What we do depends on the value of the variable "action" - switch statement
			case "start":
				System.out.println("The start of the story");
				storyMessage = "You've begun your journey!  Now you reach a junction.  Which way do you go?  Left or right?  Click below.";
				leftLink = "left";
				rightLink = "right";
				break;
			case "left":
				System.out.println("Going left");
				storyMessage = "You decided to go left at the fork in the road.  A very angry dog is there waiting for you.  How do you deal with the dog?";
				leftLink = "petdog";
				rightLink = "throwsteak";
				break;
			case "right":
				System.out.println("Going right");
				storyMessage = "You've opted to go right at the junction.  Along the way, you noticed a very large oak tree.  Exhaustion sinks in.  What do you do when you reach the tree?";
				leftLink = "continue";
				rightLink = "rest";
				break;
			default: // Runs at end if we don't break and/or no cases match
				storyMessage = "Invalid option.  You're going back to the start of the story!";
				leftLink = "start";
				rightLink = "start";
				System.out.println("We run this if none of the cases match");
		}
		// Send message and links accordingly
		viewModel.addAttribute("message", storyMessage);
		viewModel.addAttribute("leftLink", leftLink);
		viewModel.addAttribute("rightLink", rightLink);
		return "story.jsp";
	}
}
