package com.mowitnow.commandinterpreter;

import java.util.ArrayList;
import java.util.List;

import com.mowitnow.motioncontrol.CardinalPoint;
import com.mowitnow.motioncontrol.Command;
import com.mowitnow.motioncontrol.InitMowBotPositionCommand;
import com.mowitnow.motioncontrol.Position;
import com.mowitnow.mowbot.MowBot;

public class InitMowBotPositionExpression extends AbstractExpression {
	private String input;

	public InitMowBotPositionExpression(String input) {
		this.input = input;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	@Override
	public List<Command> interpret(InterpreterContext context) {
		// Each time an initMowBotPosition is issued, we create a bot
		MowBot mowBot = new MowBot();
		
		List<Command> commands = new ArrayList<Command>();
		Position position = new Position();
		
		// Parsing the string to extact position data
		String[] mowBotPosition = input.split(" ");
		int x = Integer.parseInt(mowBotPosition[0]);
		int y = Integer.parseInt(mowBotPosition[1]);
		CardinalPoint orientation = CardinalPoint.valueOf(mowBotPosition[2]);
		
		// Setting the position data
		position.setX(x);
		position.setY(y);
		position.setOrientation(orientation);
		// Setting the bot position
		mowBot.setPosition(position);
		
		// Associate the bot and the current context lawn area together
		mowBot.setLawnArea(context.getLawnArea());
		context.setMowBot(mowBot);
		context.getLawnArea().getMowers().add(mowBot);
		context.getMowBots().add(mowBot);
		
		// Generating the command
		commands.add(new InitMowBotPositionCommand(mowBot, position));

		return commands;

	}

}
