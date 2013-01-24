package com.mowitnow.motioncontrol;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mowitnow.mowbot.MowBot;

public class TurnRightCommandTest {
	private TurnRightCommand turnRightCommand;
	private MowBot mowBot;

	@Before
	public void setUp() throws Exception {
		mowBot = new MowBot();
		mowBot.setPosition(new Position(4, 7, CardinalPoint.W));
		turnRightCommand = new TurnRightCommand(mowBot);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTurnRightCommand() {
		assertNotNull(turnRightCommand);
	}

	@Test
	public void testExecute() {
		turnRightCommand.execute();
		assertEquals(4, mowBot.getPosition().getX());
		assertEquals(7,	mowBot.getPosition().getY());
		assertNotSame(CardinalPoint.E, mowBot.getPosition().getOrientation());
		assertEquals(CardinalPoint.N, mowBot.getPosition().getOrientation());
	}

}
