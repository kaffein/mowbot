package com.mowitnow.inputdata;

import java.util.List;

/**
 * This interface defines the contract for an input provider
 * may it be a file, an inputstream etc.
 * @author nasoloaina
 *
 */
public interface InputData {

	public List<String> getInput();

}
