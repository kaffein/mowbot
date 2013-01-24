package com.mowitnow.motioncontrol;

import com.mowitnow.mowbot.MowBot;

public class TurnLeftCommand implements Command {
	private MowBot mowBot;

	public TurnLeftCommand(MowBot mowBot) {
		this.mowBot = mowBot;
	}

	public void execute() {
		if (mowBot.getPosition().getOrientation().equals(CardinalPoint.N))
			mowBot.getPosition().setOrientation(CardinalPoint.W);
		else if (mowBot.getPosition().getOrientation().equals(CardinalPoint.W))
			mowBot.getPosition().setOrientation(CardinalPoint.S);
		else if (mowBot.getPosition().getOrientation().equals(CardinalPoint.S))
			mowBot.getPosition().setOrientation(CardinalPoint.E);
		else if (mowBot.getPosition().getOrientation().equals(CardinalPoint.E))
			mowBot.getPosition().setOrientation(CardinalPoint.N);
	}

}
