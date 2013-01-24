package com.mowitnow.motioncontrol;

public enum Actions {
	D("D"), G("G"), A("A");
	
	private String value;
	
	private Actions(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
