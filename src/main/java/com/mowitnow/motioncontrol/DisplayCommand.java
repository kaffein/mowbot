package com.mowitnow.motioncontrol;

import com.mowitnow.mowbot.MowBot;

public class DisplayCommand implements Command {
	private MowBot mowBot;
	private String output;

	public DisplayCommand(MowBot mowBot) {
		this.mowBot = mowBot;
	}

	public MowBot getMowBot() {
		return mowBot;
	}

	public void setMowBot(MowBot mowBot) {
		this.mowBot = mowBot;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public void execute() {
		output = mowBot.getPosition().getX() + " "
				+ mowBot.getPosition().getY() + " "
				+ mowBot.getPosition().getOrientation().getValue();
		System.out.println(output);
	}
}
