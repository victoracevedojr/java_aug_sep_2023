package pokemonTrainerDemo;

import java.util.ArrayList;

public class AceTrainer extends Trainer {
	
	public AceTrainer() {
		super();
	}
	
	public AceTrainer(String name) {
		super(name);
	}
	
	public AceTrainer(String name, ArrayList<String> pokemon) {
		super(name, pokemon);
	}
	
	public void bragAboutOutfit() {
		System.out.println("I'm cool and I have stylish clothes to show that I'm a powerful trainer!");
	}
}
