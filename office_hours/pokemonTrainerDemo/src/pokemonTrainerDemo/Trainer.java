package pokemonTrainerDemo;

import java.util.ArrayList;

public class Trainer {
	private String name; // Name of the trainer
	private ArrayList<String> pokemon; // Array (list) of Pokemon held by this trainer
	
	public Trainer() {
		this.name = "Ash";
		this.pokemon = new ArrayList<String>(); // Start with an empty list of Pokemon
	}
	
	public Trainer(String name) {
		this.name = name;
		this.pokemon = new ArrayList<String>(); // Start with an empty list of Pokemon
	}
	
	public Trainer(String name, ArrayList<String> pokemon) {
		this.name = name;
		this.pokemon = pokemon;
	}
	
	// Getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getPokemon() {
		return pokemon;
	}

	public void setPokemon(ArrayList<String> pokemon) {
		this.pokemon = pokemon;
	}
	
	// Challenging a trainer
	public void challengeTrainer(Trainer otherTrainer) {
		// Notice how we're passing in a Trainer object, and also calling each trainer's names!
		System.out.println("I, " + this.name + ", challenge you, "+ otherTrainer.getName() + ", to battle!");
	}
	
	// Catching a Pokemon
	public void catchPokemon(String newPokemon) {
		this.pokemon.add(newPokemon);
	}
	
	// Release a Pokemon
	public void releasePokemon(String pokemonToLetGo) {
		this.pokemon.remove(pokemonToLetGo);
	}
}
