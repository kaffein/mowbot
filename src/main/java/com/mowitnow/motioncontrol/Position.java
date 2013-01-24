package com.mowitnow.motioncontrol;


public class Position {
	private static final String SEPARATOR = " ";
	
	private int x;
	private int y;
	private CardinalPoint orientation;
	
	public Position() {
	}
	
	public Position(int x, int y, CardinalPoint orientation) {
		this.x = x;
		this.y = y;
		this.orientation = orientation;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public CardinalPoint getOrientation() {
		return orientation;
	}

	public void setOrientation(CardinalPoint orientation) {
		this.orientation = orientation;
	}
	
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(x);
		buffer.append(SEPARATOR);
		buffer.append(y);
		buffer.append(SEPARATOR);
		buffer.append(orientation.getValue());
		
		return buffer.toString();
	}
	
}
