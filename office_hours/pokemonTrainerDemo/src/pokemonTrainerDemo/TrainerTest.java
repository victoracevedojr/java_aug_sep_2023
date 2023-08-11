package pokemonTrainerDemo;

public class TrainerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AceTrainer adrian = new AceTrainer("Adrian");
		adrian.bragAboutOutfit();
		Hiker kim = new Hiker("Kim");
		kim.bragAboutOutfit();
		adrian.challengeTrainer(kim); // You can pass in instances of subclasses, like Hikers, AceTrainers, etc.
		adrian.catchPokemon("Dragonite");
		kim.catchPokemon("Geodude");
		kim.catchPokemon("Onyx");
		adrian.catchPokemon("Ampharos");
		adrian.catchPokemon("Sentret");
		System.out.println(adrian.getPokemon());
		System.out.println(kim.getPokemon());
		adrian.releasePokemon("Sentret");
		System.out.println(adrian.getPokemon());
		
	}

}
