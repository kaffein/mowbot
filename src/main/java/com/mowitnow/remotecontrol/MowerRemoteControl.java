package com.mowitnow.remotecontrol;

import java.util.ArrayList;
import java.util.List;

import com.mowitnow.commandinterpreter.AbstractExpression;
import com.mowitnow.commandinterpreter.DisplayExpression;
import com.mowitnow.commandinterpreter.InitLawnAreaBoundariesExpression;
import com.mowitnow.commandinterpreter.InitMowBotPositionExpression;
import com.mowitnow.commandinterpreter.InterpreterContext;
import com.mowitnow.commandinterpreter.MotionExpression;
import com.mowitnow.inputdata.InputData;
import com.mowitnow.motioncontrol.Command;
import com.mowitnow.motioncontrol.MacroCommand;

public class MowerRemoteControl {
	private InterpreterContext context;
	private Command command;
	private InputData inputData;

	public MowerRemoteControl(InputData inputData) {
		this.inputData = inputData;
		command = new MacroCommand();
		context = new InterpreterContext();
	}

	public MowerRemoteControl() {
		context = new InterpreterContext();
		command = new MacroCommand();
	}

	public InterpreterContext getContext() {
		return context;
	}

	public void setContext(InterpreterContext context) {
		this.context = context;
	}

	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}

	public InputData getInputData() {
		return inputData;
	}

	public void setInputData(InputData inputData) {
		this.inputData = inputData;
	}

	/**
	 * This method will allow the execution of all the commands
	 */
	public void launch() {
		command.execute();
	}

	/**
	 * This method will allow us to interpret each command from the InputData
	 * object and store them in the Command variable
	 */
	public void interpret() {
		MacroCommand macro = new MacroCommand();
		List<Command> commands = new ArrayList<Command>();
		for (String stringCommand : getInputData().getInput()) {
			AbstractExpression expression = null;

			String[] stringCommandParts = stringCommand.split(" ");
			if (stringCommandParts.length == 2) {
				expression = new InitLawnAreaBoundariesExpression(stringCommand);
			} else if (stringCommandParts.length == 3) {
				expression = new InitMowBotPositionExpression(stringCommand);
			} else {
				expression = new MotionExpression(stringCommand);
			}

			// Interpret input data
			commands = expression.interpret(context);
			macro.getCommands().addAll(commands);

			if (expression instanceof MotionExpression) {
				expression = new DisplayExpression();
				List<Command> displayCommands = new ArrayList<Command>();
				displayCommands = expression.interpret(context);
				macro.getCommands().addAll(displayCommands);
			}

		}
		// Putting all command in command variable
		setCommand(macro);

	}

}