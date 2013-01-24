package com.mowitnow.motioncontrol;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mowitnow.mowbot.LawnArea;

public class InitLawnAreaBoundariesCommandTest {
	private InitLawnAreaBoundariesCommand initLawnAreaBoundariesCommand;
	private LawnArea lawnArea;

	@Before
	public void setUp() throws Exception {
		lawnArea = new LawnArea();
		lawnArea.setUpperRightMostX(23);
		lawnArea.setUpperRightMostY(14);
		initLawnAreaBoundariesCommand = new InitLawnAreaBoundariesCommand(
				lawnArea);
		initLawnAreaBoundariesCommand.setX(6);
		initLawnAreaBoundariesCommand.setY(10);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInitLawnAreaBoundariesCommand() {
		assertNotNull(initLawnAreaBoundariesCommand);
	}

	@Test
	public void testGetLawnArea() {
		assertNotNull(initLawnAreaBoundariesCommand.getLawnArea());
	}

	@Test
	public void testSetLawnArea() {
		lawnArea = new LawnArea(1, 4);
		initLawnAreaBoundariesCommand.setLawnArea(lawnArea);
		assertEquals(1, initLawnAreaBoundariesCommand.getLawnArea()
				.getUpperRightMostX());
		assertEquals(4, initLawnAreaBoundariesCommand.getLawnArea()
				.getUpperRightMostY());
	}

	@Test
	public void testGetX() {
		initLawnAreaBoundariesCommand.setX(4);
		assertEquals(4, initLawnAreaBoundariesCommand.getX());
	}

	@Test
	public void testSetX() {
		initLawnAreaBoundariesCommand.setX(5);
		assertNotSame(4, initLawnAreaBoundariesCommand.getX());
	}

	@Test
	public void testGetY() {
		initLawnAreaBoundariesCommand.setY(7);
		assertEquals(7, initLawnAreaBoundariesCommand.getY());
	}

	@Test
	public void testSetY() {
		initLawnAreaBoundariesCommand.setY(2);
		assertNotSame(4, initLawnAreaBoundariesCommand.getY());
	}

	@Test
	public void testExecute() {
		assertEquals(6, initLawnAreaBoundariesCommand.getX());
		assertEquals(10, initLawnAreaBoundariesCommand.getY());
	}

}
