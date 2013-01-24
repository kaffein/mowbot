package com.mowitnow.motioncontrol;

import com.mowitnow.mowbot.LawnArea;

public class InitLawnAreaBoundariesCommand implements Command {
	private LawnArea lawnArea;
	private int x;
	private int y;

	public InitLawnAreaBoundariesCommand(LawnArea lawnArea) {
		this.lawnArea = lawnArea;
	}

	public LawnArea getLawnArea() {
		return lawnArea;
	}

	public void setLawnArea(LawnArea lawnArea) {
		this.lawnArea = lawnArea;
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

	public void execute() {
		lawnArea.setUpperRightMostX(x);
		lawnArea.setUpperRightMostY(y);
	}

}
