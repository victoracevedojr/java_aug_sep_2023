

import java.util.ArrayList;

public class Phone {
	/* Attributes we came up with during lecture (didn't use them all):
	 * Phone number
	 * Size
	 * Carrier
	 * Buttons
	 * Camera
	 * (Signal type)
	 * Case
	 * Apps
	 */
	
	// Member variables (or attributes) for each phone
	private String phoneNumber; // Note these attributes are private by convention - only the class can directly access these; nothing outside the class
	private String carrier;
	private boolean hasCase;
	private double screenDiagonal;
	private ArrayList<String> apps;
	
	// Class variables
	private static String emergencyNumber = "911";
	private static int totalTexts = 0;
	
	// Empty constructor (for Java beans later this week)
	public Phone() {
		
	}
	
	// To allow just a phone number to be specified with other defaults used
	public Phone(String phoneNumber) {
		this(phoneNumber, "AT&T", false, 6.5, new ArrayList<String>()); // Call on constructor below
	}
	
	// Constructor with ALL attributes
	public Phone(String phoneNumber, String carrier, boolean hasCase, double screenDiagonal, ArrayList<String> apps) {
		this.phoneNumber = phoneNumber;
		this.carrier = carrier;
		this.hasCase = hasCase;
		this.screenDiagonal = screenDiagonal;
		this.apps = apps;
	}
	
	// Getter static (class) methods for the private class variables
	public static String getEmergencyNumber() {
		return emergencyNumber;
	}

	public static int getTotalTexts() {
		return totalTexts;
	}

	public void sendText(String phoneNumberToSendTo, String messageToSend) {
		System.out.println(messageToSend + " sent to " + phoneNumberToSendTo);
	}

	// Getter and setter methods
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public boolean isHasCase() {
		return hasCase;
	}

	public void setHasCase(boolean hasCase) {
		this.hasCase = hasCase;
	}

	public double getScreenDiagonal() {
		return screenDiagonal;
	}

	public void setScreenDiagonal(double screenDiagonal) {
		this.screenDiagonal = screenDiagonal;
	}

	public ArrayList<String> getApps() {
		return apps;
	}

	public void setApps(ArrayList<String> apps) {
		this.apps = apps;
	}
	
	// Allow us to add (install) apps - how can you remove an app?
	public void installApp(String newApp) {
		apps.add(newApp);
	}
}
