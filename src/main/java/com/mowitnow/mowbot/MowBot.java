package com.mowitnow.mowbot;

import com.mowitnow.motioncontrol.Position;

public class MowBot {
	private Position position;
	private LawnArea lawnArea;

	public MowBot() {
	}

	public MowBot(Position position) {
		this.position = position;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public LawnArea getLawnArea() {
		return lawnArea;
	}

	public void setLawnArea(LawnArea lawnArea) {
		this.lawnArea = lawnArea;
	}

	public void display() {
		System.out.println(position.getX() + " " + position.getY() + " "
				+ position.getOrientation().getValue());
	}

}
