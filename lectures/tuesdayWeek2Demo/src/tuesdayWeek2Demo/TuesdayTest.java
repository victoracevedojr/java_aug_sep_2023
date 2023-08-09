package tuesdayWeek2Demo;

public class TuesdayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Phone myPhone = new Phone("1-800-555-JAVA");
		System.out.println(myPhone.getCarrier()); // Can't do myPhone.carrier - must use the getter method
		// Add apps to phone
		myPhone.installApp("Facebook");
		myPhone.installApp("Discord");
		System.out.println(myPhone.getApps());
	}

}
