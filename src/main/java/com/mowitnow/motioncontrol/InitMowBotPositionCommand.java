package com.mowitnow.motioncontrol;

import com.mowitnow.mowbot.MowBot;

public class InitMowBotPositionCommand implements Command {
	private MowBot mowBot;
	private Position position;

	public InitMowBotPositionCommand(MowBot mowBot, Position position) {
		this.mowBot = mowBot;
		this.position = position;
	}

	public void execute() {
		mowBot.setPosition(position);
	}

	public MowBot getMowBot() {
		return mowBot;
	}

	public void setMowBot(MowBot mowBot) {
		this.mowBot = mowBot;
	}

}
