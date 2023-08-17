package pokemonDemo;

import java.util.ArrayList;
import java.util.Scanner;

public class Pokemon {
	/*
	 * Various attributes that describe a Pokemon:
	 * Name of species
	 * Nickname of Pokemon
	 * Level
	 * Type(s)
	 * Health
	 * Pokedex info - height, weight, text entry (info)
	 * Attack stat
	 * Sp. Atk stat
	 * Speed
	 * Defense
	 * Sp. Def
	 * Move set
	 */
	private String speciesName;
	private int attack;
	private int defense;
	private int maxHP;
	private int currentHP; // How much HP the Pokemon has right now
	private ArrayList<Move> moveSet; // An array list of up to 4 moves
	
	public Pokemon() {
		
	}
	
	public Pokemon(String speciesName, int attack, int defense, int maxHP, int currentHP, ArrayList<Move> moveSet) {
		this.speciesName = speciesName;
		this.attack = attack;
		this.defense = defense;
		this.maxHP = maxHP;
		this.currentHP = currentHP;
		this.moveSet = moveSet;
	}
	
	public String getSpeciesName() {
		return speciesName;
	}
	public void setSpeciesName(String speciesName) {
		this.speciesName = speciesName;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public int getMaxHP() {
		return maxHP;
	}
	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}
	public int getCurrentHP() {
		return currentHP;
	}
	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}
	public ArrayList<Move> getMoveSet() {
		return moveSet;
	}
	public void setMoveSet(ArrayList<Move> moveSet) {
		this.moveSet = moveSet;
	}
	
	// Battle a Pokemon
	public void battlePokemon(Pokemon opponent) {
		/*  First Pokemon will select a move */
		// Display both Pokemon's HP
		System.out.println("Your " + this.speciesName + " has " + this.currentHP + "/" + this.maxHP);
		System.out.println("The opponent's " + opponent.getSpeciesName() + " has " + opponent.getCurrentHP() + "/" + opponent.getMaxHP());
		
		System.out.println("Please select a move by number for " + this.speciesName + ":");
		// Display those moves
		for (int i = 0; i < this.moveSet.size(); i++) {
			Move curMove = this.moveSet.get(i);
			System.out.println(i + ": " + curMove.getName() + ": " + curMove.getUsesLeft() + "/" + curMove.getTotalUses());
		}
		// Pick the move
		int moveIndex = -1;
		while (!(moveIndex >= 0 && moveIndex <= this.moveSet.size()-1)) {
			Scanner myScanner = new Scanner(System.in);
			moveIndex = myScanner.nextInt();
//			myScanner.close(); // Led to error when this was included
		}
		Move pickedMove = this.moveSet.get(moveIndex);
		System.out.println("You picked "+ pickedMove.getName());
		// Decrease the number of available uses for that Pokemon
		pickedMove.setUsesLeft(pickedMove.getUsesLeft()-1);
		// First Pokemon will then attack the opponent
		int totalAttack = pickedMove.getAttackPower() + this.attack;
		int calculatedDamage = totalAttack - opponent.getDefense();
		int opponentHPLeft = Math.max(0, opponent.getCurrentHP() - calculatedDamage); // Ensure nobody goes below 0 HP
		opponent.setCurrentHP(opponentHPLeft); // Save updated HP stat for foe
		if (opponentHPLeft == 0) {
			System.out.println("You defeated "+ opponent.getSpeciesName()+"!");
		}
		System.out.println("You inflicted " + calculatedDamage + " damage!");
		System.out.println(opponent.getSpeciesName() + " has " + opponent.getCurrentHP() + " HP left");


	}
	
}
