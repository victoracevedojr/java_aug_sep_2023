import java.util.ArrayList;

public class ApplePhone extends Phone {
	private String versionNumber;
	
	// Constructor for this class
	public ApplePhone(String phoneNumber) {
		super(phoneNumber); // Call on the Phone(phoneNumber)
		this.versionNumber = "16.5.1";
	}
	
	public ApplePhone(String phoneNumber, String carrier, boolean hasCase, 
			double screenDiagonal, ArrayList<String> apps, String versionNumber) {
		super(phoneNumber, carrier, hasCase, screenDiagonal, apps); // Call on the Phone() constructor
		this.versionNumber = versionNumber;
	}

	// No other getters and setters needed - we inherited those from the Phone class, along with other
	// method we defined, such as installApps!
	public String getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}
	
	
}
