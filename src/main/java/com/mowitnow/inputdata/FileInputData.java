package com.mowitnow.inputdata;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides a way to load input data from a file
 * 
 * @author nasoloaina
 * 
 */
public class FileInputData implements InputData {
	private File file;

	public FileInputData(File file) {
		this.file = file;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	/**
	 * File parsing
	 */
	public List<String> getInput() {
		List<String> stringCommands = new ArrayList<String>();
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(file);
			DataInputStream dataInputStream = new DataInputStream(
					fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(dataInputStream));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				stringCommands.add(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return stringCommands;
	}

}
