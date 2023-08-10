import java.util.ArrayList;

public class AndroidPhone extends Phone {
	private String candyVersion;
	
	// Constructor for this class
	public AndroidPhone(String phoneNumber) {
		super(phoneNumber); // Call on the Phone(phoneNumber)
		this.candyVersion = "Upside Down Cake";
	}
	
	public AndroidPhone(String phoneNumber, String carrier, boolean hasCase, 
			double screenDiagonal, ArrayList<String> apps, String candyVersion) {
		super(phoneNumber, carrier, hasCase, screenDiagonal, apps); // Call on the Phone() constructor
		this.candyVersion = candyVersion;
	}

	
	// No other getters and setters needed - we inherited those from the Phone class, along with other
	// method we defined, such as installApps!
	public String getCandyVersion() {
		return candyVersion;
	}

	public void setCandyVersion(String candyVersion) {
		this.candyVersion = candyVersion;
	}
	
	
}
