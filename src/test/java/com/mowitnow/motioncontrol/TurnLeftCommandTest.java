package com.mowitnow.motioncontrol;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mowitnow.mowbot.MowBot;

public class TurnLeftCommandTest {
	private TurnLeftCommand turnLeftCommand;
	private MowBot mowBot;

	@Before
	public void setUp() throws Exception {
		mowBot = new MowBot();
		mowBot.setPosition(new Position(2, 5, CardinalPoint.S));
		turnLeftCommand = new TurnLeftCommand(mowBot);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTurnLeftCommand() {
		assertNotNull(turnLeftCommand);
	}

	@Test
	public void testExecute() {
		turnLeftCommand.execute();
		assertEquals(2, mowBot.getPosition().getX());
		assertEquals(5, mowBot.getPosition().getY());
		assertNotSame(CardinalPoint.S, mowBot.getPosition().getOrientation());
		assertEquals(CardinalPoint.E, mowBot.getPosition().getOrientation());
	}

}
