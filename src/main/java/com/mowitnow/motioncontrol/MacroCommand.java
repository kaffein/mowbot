package com.mowitnow.motioncontrol;

import java.util.ArrayList;
import java.util.List;

/**
 * We will use this Macro command object to manage the queuing of commands
 * 
 * @author nasoloaina
 * 
 */
public class MacroCommand implements Command {
	private List<Command> commands = new ArrayList<Command>();

	public MacroCommand() {
	}

	public MacroCommand(List<Command> commands) {
		this.commands = commands;
	}

	public List<Command> getCommands() {
		return commands;
	}

	public void setCommands(List<Command> commands) {
		this.commands = commands;
	}

	public void execute() {
		for (Command command : commands) {
			command.execute();
		}
	}

}
