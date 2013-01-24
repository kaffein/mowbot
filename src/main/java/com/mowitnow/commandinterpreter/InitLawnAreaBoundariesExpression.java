package com.mowitnow.commandinterpreter;

import java.util.ArrayList;
import java.util.List;

import com.mowitnow.motioncontrol.Command;
import com.mowitnow.motioncontrol.InitLawnAreaBoundariesCommand;

public class InitLawnAreaBoundariesExpression extends AbstractExpression {
	private String input;

	public InitLawnAreaBoundariesExpression(String input) {
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
		List<Command> commands = new ArrayList<Command>();
		String[] lawnAreaCoordinates = input.split(" ");
		context.getLawnArea().setUpperRightMostX(Integer
				.parseInt(lawnAreaCoordinates[0]));
		context.getLawnArea().setUpperRightMostY(Integer
				.parseInt(lawnAreaCoordinates[1]));
		
		InitLawnAreaBoundariesCommand initLawnAreaBoundariesCommand = new InitLawnAreaBoundariesCommand(context.getLawnArea());
		initLawnAreaBoundariesCommand.setX(Integer
				.parseInt(lawnAreaCoordinates[0]));
		initLawnAreaBoundariesCommand.setY(Integer
				.parseInt(lawnAreaCoordinates[1]));
		commands.add(initLawnAreaBoundariesCommand);
		//commands.add(new InitLawnAreaBoundariesCommand(context.getLawnArea()));

		return commands;
	}

}
