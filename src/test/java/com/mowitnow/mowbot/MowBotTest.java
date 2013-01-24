package com.mowitnow.mowbot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mowitnow.motioncontrol.CardinalPoint;
import com.mowitnow.motioncontrol.Position;

public class MowBotTest {
	private MowBot myBot;
	private Position newPosition;
	private LawnArea lawnArea;

	@Before
	public void setUp() throws Exception {

		myBot = new MowBot();
		myBot.setPosition(new Position(12, 4, CardinalPoint.S));

		newPosition = new Position(9, 2, CardinalPoint.W);
		
		lawnArea = new LawnArea();
		lawnArea.setUpperRightMostX(20);
		lawnArea.setUpperRightMostY(40);
		
	}

	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMowBot() {
		assertNotNull(myBot);
	}

	@Test
	public void testGetPosition() {
		assertNotNull(myBot.getPosition());
		assertEquals(12, myBot.getPosition().getX());
		assertEquals(4, myBot.getPosition().getY());
	}

	@Test
	public void testSetPosition() {
		myBot.setPosition(newPosition);
		assertNotNull(myBot.getPosition());
		assertEquals(9, myBot.getPosition().getX());
		assertEquals(2, myBot.getPosition().getY());
		assertEquals(CardinalPoint.W, myBot.getPosition().getOrientation());
	}

	@Test
	public void testGetLawnArea() {
		assertNull(myBot.getLawnArea());
	}

	@Test
	public void testSetLawnArea() {
		myBot.setLawnArea(lawnArea);
		assertNotNull(myBot.getLawnArea());
		assertEquals(20, myBot.getLawnArea().getUpperRightMostX());
		assertEquals(40, myBot.getLawnArea().getUpperRightMostY());
	}

}