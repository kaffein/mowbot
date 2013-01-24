package com.mowitnow.motioncontrol;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.mowitnow.mowbot.LawnArea;
import com.mowitnow.mowbot.MowBot;

public class MoveForwardCommandTest {
	private MoveForwardCommand moveForwardCommand;
	private MowBot mowBot;
	private LawnArea lawnArea;
	private Position position;

	@Before
	public void setUp() throws Exception {
		mowBot = new MowBot();
		lawnArea = new LawnArea();
		lawnArea.setUpperRightMostX(10);
		lawnArea.setUpperRightMostY(13);
		position = new Position(3, 4, CardinalPoint.N);
		
		mowBot.setPosition(position);
		mowBot.setLawnArea(lawnArea);
		
		moveForwardCommand = new MoveForwardCommand(mowBot);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMoveForwardCommand() {
		assertNotNull(moveForwardCommand);
	}

	@Test
	public void testExecute() {
		moveForwardCommand.execute();
		assertEquals(3, mowBot.getPosition().getX());
		assertNotSame(4, mowBot.getPosition().getY());
		assertEquals(5, mowBot.getPosition().getY());
		assertEquals(CardinalPoint.N, mowBot.getPosition().getOrientation());
	}

	@Test
	public void testUndo() {
		assertEquals(3, mowBot.getPosition().getX());
		assertEquals(4, mowBot.getPosition().getY());
		assertEquals(CardinalPoint.N, mowBot.getPosition().getOrientation());
		
		// Chaging test conditions
		mowBot.getPosition().setX(10);
		mowBot.getPosition().setY(13);
		mowBot.getPosition().setOrientation(CardinalPoint.N);
		// Firing ...
		moveForwardCommand.execute();
		
		// Checking previous state
		assertEquals(10, moveForwardCommand.getPreviousPosition().getX());
		assertEquals(13, moveForwardCommand.getPreviousPosition().getY());
		
		// Checking if previous state was restored
		assertEquals(10, mowBot.getPosition().getX());
		assertEquals(13, mowBot.getPosition().getY());
		assertEquals(CardinalPoint.N, mowBot.getPosition().getOrientation());
	}

	@Test
	public void testIsCurrentPositionReachable() {
		assertTrue(mowBot.getPosition().getX() > 0);
		assertTrue(mowBot.getPosition().getX() < lawnArea.getUpperRightMostX());
		assertTrue(mowBot.getPosition().getY() > 0);
		assertTrue(mowBot.getPosition().getY() < lawnArea.getUpperRightMostY());
		
		mowBot.setPosition(new Position(10, 13, CardinalPoint.N));
		moveForwardCommand.execute();
		assertFalse(mowBot.getPosition().getY() < lawnArea.getUpperRightMostY());
	}

}
