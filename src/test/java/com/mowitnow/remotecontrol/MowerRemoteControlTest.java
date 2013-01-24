package com.mowitnow.remotecontrol;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.mowitnow.commandinterpreter.InterpreterContext;
import com.mowitnow.inputdata.FileInputData;
import com.mowitnow.inputdata.SimpleInputData;
import com.mowitnow.motioncontrol.CardinalPoint;

public class MowerRemoteControlTest {
	private MowerRemoteControl mowerRemoteControl;
	private SimpleInputData simpleInputData;
	private FileInputData fileInputData;
	private InterpreterContext context;

	@Before
	public void setUp() throws Exception {
		// Initializing input providers
		simpleInputData = new SimpleInputData();
		simpleInputData.getStringCommands().add("5 5");
		simpleInputData.getStringCommands().add("1 2 N");
		simpleInputData.getStringCommands().add("GAGAGAGAA");
		simpleInputData.getStringCommands().add("3 3 E");
		simpleInputData.getStringCommands().add("AADAADADDA");

		// Used as an alternative to get data from simpleInputData
		fileInputData = new FileInputData(new File("command.file"));

		mowerRemoteControl = new MowerRemoteControl();
		mowerRemoteControl.setInputData(simpleInputData);
		context = new InterpreterContext();
		mowerRemoteControl.setContext(context);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMowerRemoteControl() {
		assertNotNull(simpleInputData);
		assertNotNull(mowerRemoteControl);
		assertNotNull(mowerRemoteControl.getContext().getLawnArea());
	}

	@Test
	public void testGetContext() {
		assertNotNull(mowerRemoteControl.getContext());
	}

	@Test
	public void testSetContext() {
		assertNotNull(mowerRemoteControl.getContext());
	}

	@Test
	public void testGetCommand() {
		assertNotNull(mowerRemoteControl.getCommand());
	}

	@Test
	public void testSetCommand() {
		assertNotNull(mowerRemoteControl.getCommand());
	}

	@Test
	public void testGetInputData() {
		assertNotNull(mowerRemoteControl.getInputData());
	}

	@Test
	public void testSetInputData() {
		assertNotNull(mowerRemoteControl.getInputData());
	}

	@Test
	public void testLaunch() {
		assertNotNull(mowerRemoteControl.getCommand());
	}

	@Test
	public void testInterpret() {
		// Interpreting & Queueing commands
		mowerRemoteControl.interpret();

		// launching the whole stuff when all commands get processed !!!
		mowerRemoteControl.launch();

		assertNotNull(mowerRemoteControl.getContext().getLawnArea());
		assertEquals(5, mowerRemoteControl.getContext().getLawnArea()
				.getUpperRightMostX());
		assertEquals(5, mowerRemoteControl.getContext().getLawnArea()
				.getUpperRightMostY());

		/**
		 * EXPECTED RESULT FOR THE 1ST LAWNMOWER : (1 3 N)
		 */
		assertEquals(1, mowerRemoteControl.getContext().getLawnArea()
				.getMowers().get(0).getPosition().getX());
		assertEquals(3, mowerRemoteControl.getContext().getLawnArea()
				.getMowers().get(0).getPosition().getY());
		assertEquals(CardinalPoint.N, mowerRemoteControl.getContext()
				.getLawnArea().getMowers().get(0).getPosition()
				.getOrientation());

		/**
		 * EXPECTED RESULT FOR THE 2ND LAWNMOWER (5 1 E)
		 */
		assertEquals(5, mowerRemoteControl.getContext().getLawnArea()
				.getMowers().get(1).getPosition().getX());
		assertEquals(1, mowerRemoteControl.getContext().getLawnArea()
				.getMowers().get(1).getPosition().getY());
		assertEquals(CardinalPoint.E, mowerRemoteControl.getContext()
				.getLawnArea().getMowers().get(1).getPosition()
				.getOrientation());
	}

	/**
	 * EXPECTING THE SAME RESULT AS ABOVE WITH A FILE AS INPUT
	 */
	@Test
	public void testFileInterpret() {
		mowerRemoteControl = new MowerRemoteControl();
		mowerRemoteControl.setInputData(fileInputData);

		context = new InterpreterContext();
		mowerRemoteControl.setContext(context);

		// Interpreting & Queueing commands
		mowerRemoteControl.interpret();

		// launching the whole stuff when all commands get processed !!!
		mowerRemoteControl.launch();

		assertNotNull(mowerRemoteControl.getContext().getLawnArea());
		assertEquals(5, mowerRemoteControl.getContext().getLawnArea()
				.getUpperRightMostX());
		assertEquals(5, mowerRemoteControl.getContext().getLawnArea()
				.getUpperRightMostY());

		/**
		 * EXPECTED RESULT FOR THE 1ST LAWNMOWER : (1 3 N)
		 */
		assertEquals(1, mowerRemoteControl.getContext().getLawnArea()
				.getMowers().get(0).getPosition().getX());
		assertEquals(3, mowerRemoteControl.getContext().getLawnArea()
				.getMowers().get(0).getPosition().getY());
		assertEquals(CardinalPoint.N, mowerRemoteControl.getContext()
				.getLawnArea().getMowers().get(0).getPosition()
				.getOrientation());

		/**
		 * EXPECTED RESULT FOR THE 2ND LAWNMOWER (5 1 E)
		 */
		assertEquals(5, mowerRemoteControl.getContext().getLawnArea()
				.getMowers().get(1).getPosition().getX());
		assertEquals(1, mowerRemoteControl.getContext().getLawnArea()
				.getMowers().get(1).getPosition().getY());
		assertEquals(CardinalPoint.E, mowerRemoteControl.getContext()
				.getLawnArea().getMowers().get(1).getPosition()
				.getOrientation());

	}
}