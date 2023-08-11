package thursdayWeek2Demo;

public interface Remote {
//	String overseer = "FCC"; // 
//	default void turnOn() { // Default methods do NOT have to be defined in any classes or methods that implement this interface
//		System.out.println("The machine is on");
//	}
	
	// Abstract methods
	void turnOn();
	
	void turnOff();
	
	void raiseVolume();
	
	void lowerVolume();
	
	void mute();
	
}
