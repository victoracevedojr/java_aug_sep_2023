package thursdayWeek2Demo;

public abstract class Television implements Remote {
	private double screenDiagonal; // 40 inches, 43 inches, etc.
	private String bestHDResolution; // 1080p, 4K, 8K, etc.
	private int screenRefreshRate; // 60fps, 120fps
	private boolean isSmart; // is it a smart TV?
	private int volumeLevel;
	private boolean isOn; // TV is on or off? (true = on, false = off)
	private boolean isMuted; 
	
	public Television() {
		this(43.0, "1080p", 60, false, 20, false, false);
	}
	
	public Television(double screenDiagonal, String bestHDResolution, int screenRefreshRate, boolean isSmart,
			int volumeLevel, boolean isOn, boolean isMuted) {
		this.screenDiagonal = screenDiagonal;
		this.bestHDResolution = bestHDResolution;
		this.screenRefreshRate = screenRefreshRate;
		this.isSmart = isSmart;
		this.volumeLevel = volumeLevel;
		this.isOn = isOn;
		this.isMuted = isMuted;
	}

	// Implement the abstract methods from the Remote interface we're implementing
	public void turnOn() {
		isOn = true;
	}
	
	public void turnOff() {
		isOn = false;
	}
	
	public void raiseVolume() {
		volumeLevel++;
	}
	
	public void lowerVolume() {
		volumeLevel--;
	}
	
	public void mute() {
		isMuted = !isMuted; // Changing whether the TV is muted or not
	}

	public double getScreenDiagonal() {
		return screenDiagonal;
	}

	public void setScreenDiagonal(double screenDiagonal) {
//		if (screenDiagonal < 0) { // Another reason why getters and setters are useful - to control what values we can use to prevent unintended side effects or behavior
//			throw new Exception(); // This can be any type of Exception - or we can display a message (or something similar) preventing the change
//		}
		this.screenDiagonal = screenDiagonal;
	}

	public String getBestHDResolution() {
		return bestHDResolution;
	}

	public void setBestHDResolution(String bestHDResolution) {
		this.bestHDResolution = bestHDResolution;
	}

	public int getScreenRefreshRate() {
		return screenRefreshRate;
	}

	public void setScreenRefreshRate(int screenRefreshRate) {
		this.screenRefreshRate = screenRefreshRate;
	}

	public boolean isSmart() {
		return isSmart;
	}

	public void setSmart(boolean isSmart) {
		this.isSmart = isSmart;
	}

	public int getVolumeLevel() {
		return volumeLevel;
	}

	public void setVolumeLevel(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}

	public boolean isOn() {
		return isOn;
	}

	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}

	public boolean isMuted() {
		return isMuted;
	}

	public void setMuted(boolean isMuted) {
		this.isMuted = isMuted;
	}
	
//	public abstract void syncDevices();
	
	// Getters and setters
	
}
