package com.mowitnow.commandinterpreter;

import java.util.ArrayList;
import java.util.List;

import com.mowitnow.motioncontrol.Command;
import com.mowitnow.motioncontrol.MoveForwardCommand;
import com.mowitnow.motioncontrol.TurnLeftCommand;
import com.mowitnow.motioncontrol.TurnRightCommand;

public class MotionExpression extends AbstractExpression {
	private String input;

	public MotionExpression(String input) {
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

		// Parsing the string to extract position data
		Command command = null;
		for (Character c : input.toCharArray()) {
			if (c.equals('D')) {
				command = new TurnRightCommand(context.getMowBot());
			} else if (c.equals('G')) {
				command = new TurnLeftCommand(context.getMowBot());
			} else {
				command = new MoveForwardCommand(context.getMowBot());
			}
			
			// Generating the command
			commands.add(command);
		}

		return commands;
	}

}
