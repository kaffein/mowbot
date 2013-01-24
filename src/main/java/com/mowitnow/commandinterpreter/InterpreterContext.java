package com.mowitnow.commandinterpreter;

import java.util.ArrayList;
import java.util.List;

import com.mowitnow.mowbot.LawnArea;
import com.mowitnow.mowbot.MowBot;

public class InterpreterContext {
	private LawnArea lawnArea;
	private MowBot mowBot;

	private List<MowBot> mowBots;

	public InterpreterContext() {
		lawnArea = new LawnArea();
		mowBots = new ArrayList<MowBot>();
	}

	public MowBot getMowBot() {
		return mowBot;
	}

	public void setMowBot(MowBot mowBot) {
		this.mowBot = mowBot;
	}

	public LawnArea getLawnArea() {
		return lawnArea;
	}

	public void setLawnArea(LawnArea lawnArea) {
		this.lawnArea = lawnArea;
	}

	public List<MowBot> getMowBots() {
		return mowBots;
	}

	public void setMowBots(List<MowBot> mowBots) {
		this.mowBots = mowBots;
	}
}