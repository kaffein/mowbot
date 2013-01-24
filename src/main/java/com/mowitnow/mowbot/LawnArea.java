package com.mowitnow.mowbot;

import java.util.ArrayList;
import java.util.List;

public class LawnArea {
	public static final int DOWN_LEFT_MOST_X = 0;
	public static final int DOWN_LEFT_MOST_Y = 0;

	private int upperRightMostX;
	private int upperRightMostY;
	private List<MowBot> mowers = new ArrayList<MowBot>();
	

	public LawnArea() {
	}

	public LawnArea(int upperRightMostX, int upperRightMostY) {
		this.upperRightMostX = upperRightMostX;
		this.upperRightMostY = upperRightMostY;
	}

	public int getUpperRightMostX() {
		return upperRightMostX;
	}

	public void setUpperRightMostX(int upperRightMostX) {
		this.upperRightMostX = upperRightMostX;
	}

	public int getUpperRightMostY() {
		return upperRightMostY;
	}

	public void setUpperRightMostY(int upperRightMostY) {
		this.upperRightMostY = upperRightMostY;
	}

	public List<MowBot> getMowers() {
		return mowers;
	}

	public void setMowers(List<MowBot> mowers) {
		this.mowers = mowers;
	}

}
