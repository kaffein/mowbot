package com.mowitnow.commandinterpreter;

import java.util.ArrayList;
import java.util.List;

import com.mowitnow.motioncontrol.Command;
import com.mowitnow.motioncontrol.DisplayCommand;

public class DisplayExpression extends AbstractExpression {

	public DisplayExpression() {
	}

	@Override
	public List<Command> interpret(InterpreterContext context) {
		// Adding the displayCommand
		List<Command> commands = new ArrayList<Command>();
		commands.add(new DisplayCommand(context.getMowBot()));

		return commands;
	}

}
