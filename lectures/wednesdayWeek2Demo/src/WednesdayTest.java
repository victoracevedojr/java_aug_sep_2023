
public class WednesdayTest {

	public static void main(String[] args) {
		// Creating specific phones with some new attributes unique to each phone
		ApplePhone apple1 = new ApplePhone("1-555-MY-APPLE"); // Can pass in other attributes if you wish
		AndroidPhone android1 = new AndroidPhone("1-555-ANDROID"); // Can pass in other attributes if you wish
		System.out.println(apple1.getCarrier()); // Use default carrier
		System.out.println(android1.getCandyVersion()); // Use default candy version for this Android phone
		
	}

}
