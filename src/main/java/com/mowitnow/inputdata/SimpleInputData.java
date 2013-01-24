package com.mowitnow.inputdata;

import java.util.ArrayList;
import java.util.List;

/**
 * We created this class for test purposes
 * 
 * @author nasoloaina
 * 
 */
public class SimpleInputData implements InputData {
	private List<String> stringCommands = new ArrayList<String>();

	public SimpleInputData() {
	}

	public List<String> getStringCommands() {
		return stringCommands;
	}

	public void setStringCommands(List<String> stringCommands) {
		this.stringCommands = stringCommands;
	}

	public List<String> getInput() {
		return stringCommands;
	}

}
