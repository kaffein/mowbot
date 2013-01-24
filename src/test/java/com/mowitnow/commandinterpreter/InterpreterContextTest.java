package com.mowitnow.commandinterpreter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mowitnow.motioncontrol.CardinalPoint;
import com.mowitnow.motioncontrol.Position;
import com.mowitnow.mowbot.LawnArea;
import com.mowitnow.mowbot.MowBot;

public class InterpreterContextTest {
	private InterpreterContext interpreterContext;
	private LawnArea lawnArea;
	private MowBot mowBot;

	@Before
	public void setUp() throws Exception {
		interpreterContext = new InterpreterContext();
		
		lawnArea = new LawnArea();
		lawnArea.setUpperRightMostX(14);
		lawnArea.setUpperRightMostY(12);
		interpreterContext.setLawnArea(lawnArea);
		
		mowBot = new MowBot();
		mowBot.setLawnArea(lawnArea);
		mowBot.setPosition(new Position(3, 8, CardinalPoint.S));
		interpreterContext.setMowBot(mowBot);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInterpreterContext() {
		assertNotNull(interpreterContext);
	}

	@Test
	public void testGetLawnArea() {
		assertNotNull(interpreterContext.getLawnArea());
		assertNotSame(3, interpreterContext.getLawnArea().getUpperRightMostX());
		assertEquals(14, interpreterContext.getLawnArea().getUpperRightMostX());
		
		assertNotSame(7, interpreterContext.getLawnArea().getUpperRightMostY());
		assertEquals(12, interpreterContext.getLawnArea().getUpperRightMostY());
		
	}

	@Test
	public void testSetLawnArea() {
		assertNotNull(interpreterContext.getLawnArea());
	}

	@Test
	public void testGetMowBot() {
		assertNotNull(interpreterContext.getMowBot());
		assertEquals(3, interpreterContext.getMowBot().getPosition().getX());
		assertEquals(8, interpreterContext.getMowBot().getPosition().getY());
		assertEquals(CardinalPoint.S, interpreterContext.getMowBot().getPosition().getOrientation());
	}

	@Test
	public void testSetMowBot() {
		interpreterContext.setMowBot(null);
		assertNull(interpreterContext.getMowBot());
	}

}
