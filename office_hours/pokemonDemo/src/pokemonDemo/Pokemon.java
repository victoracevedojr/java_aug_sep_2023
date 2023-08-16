package pokemonDemo;

import java.util.ArrayList;

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
	
}
