package pokemonDemo;

import java.util.ArrayList;
import java.util.Scanner;

public class Trainer {
	private String name; // Name of the trainer
	private ArrayList<Pokemon> pokemon; // Array (list) of Pokemon held by this trainer
	
	public Trainer() {
		this.name = "Ash";
		this.pokemon = new ArrayList<Pokemon>(); // Start with an empty list of Pokemon
	}
	
	public Trainer(String name) {
		this.name = name;
		this.pokemon = new ArrayList<Pokemon>(); // Start with an empty list of Pokemon
	}
	
	public Trainer(String name, ArrayList<Pokemon> pokemon) {
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
	
	public ArrayList<Pokemon> getPokemon() {
		return pokemon;
	}

	public void setPokemon(ArrayList<Pokemon> pokemon) {
		this.pokemon = pokemon;
	}

	// Challenging a trainer
	public void challengeTrainer(Trainer otherTrainer) {
		// Notice how we're passing in a Trainer object, and also calling each trainer's names!
		System.out.println("I, " + this.name + ", challenge you, "+ otherTrainer.getName() + ", to battle!");
		
		// Select our Pokemon by asking in the console
		boolean firstTrainerPicked = false;
		boolean secondTrainerPicked = false;
		int firstPokemonIndex = -1;
		int secondPokemonIndex = -1;
		String pokemonToUse;
		// The challenging trainer will pick a Pokemon
		while (!firstTrainerPicked) {
			System.out.println(this.name + ", select a Pokemon to battle with:");
			Scanner myScanner = new Scanner(System.in); // Read in data from console
			pokemonToUse = myScanner.nextLine(); // Read in Pokemon name
			// Search for that Pokemon - if found, use that, but if not, ask again
			for (int i = 0; i < this.pokemon.size(); i++) {
				Pokemon curPokemon = this.pokemon.get(i);
				if (curPokemon.getSpeciesName().equals(pokemonToUse)) { // If name matches current Pokemon
					firstTrainerPicked = true;
					firstPokemonIndex = i;
					break; // Exit the for loop
				}
			}
		}
		// The challenged trainer will now pick one
		while (!secondTrainerPicked) {
			System.out.println(otherTrainer.getName() + ", select a Pokemon to battle with:");
			Scanner myScanner = new Scanner(System.in);
			pokemonToUse = myScanner.nextLine(); // Read in Pokemon name
			// Search for that Pokemon - if found, use that, but if not, ask again
			for (int i = 0; i < otherTrainer.getPokemon().size(); i++) {
				Pokemon curPokemon = otherTrainer.getPokemon().get(i);
				if (curPokemon.getSpeciesName().equals(pokemonToUse)) {
					secondTrainerPicked = true;
					secondPokemonIndex = i;
					break; // Exit the for loop
				}
			}
		}
		System.out.println("Both Pokemon selected!");
		// Wednesday we'll add logic to pick moves and battle!
	}
	
	// Catching a Pokemon
	public void catchPokemon(Pokemon newPokemon) {
		this.pokemon.add(newPokemon);
	}
	
	// Release a Pokemon
	public void releasePokemon(Pokemon pokemonToLetGo) {
		this.pokemon.remove(pokemonToLetGo);
	}
}
