package thursdayWeek2Demo;

public class DojoTelevision extends Television {
	// Need these constructors below so we can create DojoTelevision instances
	public DojoTelevision() {
		super();
	}
	
	public DojoTelevision(double screenDiagonal, String bestHDResolution, int screenRefreshRate, 
			boolean isSmart, int volumeLevel, boolean isOn, boolean isMuted) {
		super(screenDiagonal, bestHDResolution, screenRefreshRate, isSmart, volumeLevel, isOn, isMuted);
	}
	
	// Method exclusive to this class
	public void connectToPlatform(String course) {
		System.out.println("Now connecting to the platform and looking at "+ course);
	}
	
}
