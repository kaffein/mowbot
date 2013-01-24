package com.mowitnow.motioncontrol;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mowitnow.mowbot.LawnArea;
import com.mowitnow.mowbot.MowBot;

public class InitMowBotPositionCommandTest {
	private InitMowBotPositionCommand initMowBotPositionCommand;
	private MowBot mowBot;
	private Position position;

	@Before
	public void setUp() throws Exception {
		mowBot = new MowBot();
		position = new Position(2, 6, CardinalPoint.S);
		initMowBotPositionCommand = new InitMowBotPositionCommand(mowBot, position);
		initMowBotPositionCommand.execute();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInitMowBotPositionCommand() {
		assertNotNull(initMowBotPositionCommand);
	}

	@Test
	public void testExecute() {
		assertEquals(2, initMowBotPositionCommand.getMowBot().getPosition().getX());
		assertEquals(6, initMowBotPositionCommand.getMowBot().getPosition().getY());
	}

}
