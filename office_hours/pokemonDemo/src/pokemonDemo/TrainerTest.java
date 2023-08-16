package pokemonDemo;

import java.util.ArrayList;

public class TrainerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AceTrainer adrian = new AceTrainer("Adrian");
		adrian.bragAboutOutfit();
		Hiker kim = new Hiker("Kim");
		kim.bragAboutOutfit();
		// Create move set and Pokemon!!
		ArrayList<Move> dragoniteMoves = new ArrayList<Move>();
		dragoniteMoves.add(new Move("Hyper Beam", 5, 5, 50));
		dragoniteMoves.add(new Move("Wing Attack", 35, 35, 10));
		dragoniteMoves.add(new Move("Outrage", 10, 10, 25));
		dragoniteMoves.add(new Move("Dragon Rage", 20, 20, 20));
		Pokemon dragonite = new Pokemon("Dragonite", 150, 100, 200, 200, dragoniteMoves);
		
		ArrayList<Move> gyaradosMoves = new ArrayList<Move>();
		gyaradosMoves.add(new Move("Twister", 25, 25, 15));
		gyaradosMoves.add(new Move("Bite", 20, 20, 20));
		gyaradosMoves.add(new Move("Hydro Pump", 5, 5, 50));
		gyaradosMoves.add(new Move("Thunder", 10, 10, 25));
		Pokemon gyarados = new Pokemon("Gyarados", 140, 120, 220, 220, gyaradosMoves);
		
		adrian.catchPokemon(dragonite);
		kim.catchPokemon(gyarados);

		adrian.challengeTrainer(kim); // You can pass in instances of subclasses, like Hikers, AceTrainers, etc.
	}

}
