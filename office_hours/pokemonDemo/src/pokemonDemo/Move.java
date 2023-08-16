package pokemonDemo;

public class Move {
	private String name; // Name of the move
	private int totalUses; // Total uses one can have
	private int usesLeft; // How many uses are left
	private int attackPower; // Attack power for move
	
	public Move() {
		
	}
	
	public Move(String name, int totalUses, int usesLeft, int attackPower) {
		this.name = name;
		this.totalUses = totalUses;
		this.usesLeft = usesLeft;
		this.attackPower = attackPower;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotalUses() {
		return totalUses;
	}
	public void setTotalUses(int totalUses) {
		this.totalUses = totalUses;
	}
	public int getUsesLeft() {
		return usesLeft;
	}
	public void setUsesLeft(int usesLeft) {
		this.usesLeft = usesLeft;
	}
	public int getAttackPower() {
		return attackPower;
	}
	public void setAttackPower(int attackPower) {
		this.attackPower = attackPower;
	}
}
