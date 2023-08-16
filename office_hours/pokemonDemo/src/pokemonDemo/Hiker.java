package pokemonDemo;

import java.util.ArrayList;

public class Hiker extends Trainer {
	
	public Hiker() {
		super();
	}
	
	public Hiker(String name) {
		super(name);
	}
	
	public Hiker(String name, ArrayList<Pokemon> pokemon) {
		super(name, pokemon);
	}
	
	public void bragAboutOutfit() {
		System.out.println("I love the outdoors, and I love Geodude and all rock and ground types!  I love this vest I'm wearing and these cool shorts and boots!");
	}
}
