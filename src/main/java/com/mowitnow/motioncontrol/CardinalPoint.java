package com.mowitnow.motioncontrol;

public enum CardinalPoint {
	N("N"), E("E"), W("W"), S("S");
	
	private String value;
	
	private CardinalPoint(String value) {
		this.value = value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
