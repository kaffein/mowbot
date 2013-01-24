package com.mowitnow.commandinterpreter;

import java.util.List;

import com.mowitnow.motioncontrol.Command;

public abstract class AbstractExpression {
	public abstract List<Command> interpret(InterpreterContext context);
}
