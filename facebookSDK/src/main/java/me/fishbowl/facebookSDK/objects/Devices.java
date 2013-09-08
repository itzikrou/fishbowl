package me.fishbowl.facebookSDK.objects;

public class Devices {

	String os;
	String hardware;

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getHardware() {
		return hardware;
	}

	public void setHardware(String hardware) {
		this.hardware = hardware;
	}

	@Override
	public String toString() {
		return "Devices [os=" + os + ", hardware=" + hardware + ", getOs()="
				+ getOs() + ", getHardware()=" + getHardware()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
