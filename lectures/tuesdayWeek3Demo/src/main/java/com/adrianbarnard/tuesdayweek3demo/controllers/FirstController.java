package com.adrianbarnard.tuesdayweek3demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // This will ONLY handle basic data, like JSON data, strings, etc.
public class FirstController {
	@RequestMapping("/") // Equivalent to localhost:8080 (and "localhost:8080/")
	public String greetings() {
		return "Greetings from Spring Boot!";
	}
	
	@GetMapping("/hello") // Same as @RequestMapping
	public String helloRoute() {
		return "<h1>This is from the hello route!</h1>";
	}
	
	// Route is localhost:8080/weather?weather=sunny&temperature=85.5; notice the "weather" and "temperature" after the "?" - these are query parameters
	@GetMapping("/weather")
	public String displayWeather(@RequestParam("weather") String currentWeather,
			@RequestParam("temperature") Double currentTemperature) {
		return "The current weather is " + currentWeather + " and it is " + currentTemperature + " degrees.";
	}
	
	@GetMapping("/blogs/{name}/{number}") // Path variables use the {} inside the route name
	public String displayBlog(@PathVariable("name") String bloggerName, @PathVariable Long number) {
		return "This is blog " + number + " by " + bloggerName;
	}
	
}
