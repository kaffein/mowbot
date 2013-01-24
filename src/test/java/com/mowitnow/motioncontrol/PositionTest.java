package com.mowitnow.motioncontrol;

import com.mowitnow.motioncontrol.CardinalPoint;
import com.mowitnow.motioncontrol.Position;

import junit.framework.TestCase;

public class PositionTest extends TestCase {
	private Position position;

	protected void setUp() throws Exception {
		super.setUp();
		position = new Position();
		position.setX(10);
		position.setY(15);
		position.setOrientation(CardinalPoint.W);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testPosition() {
		assertNotNull(position);
	}

	public void testGetX() {
		assertEquals(10, position.getX());
	}

	public void testSetX() {
		position.setX(3);
		assertEquals(3, position.getX());
	}

	public void testGetY() {
		assertEquals(15, position.getY());
	}

	public void testSetY() {
		position.setY(9);
		assertEquals(9, position.getY());
	}

	public void testGetOrientation() {
		assertEquals(CardinalPoint.W, position.getOrientation());
	}

	public void testSetOrientation() {
		position.setOrientation(CardinalPoint.S);
		assertEquals(CardinalPoint.S, position.getOrientation());
	}

	public void testToString() {
		assertEquals("10 15 W", position.toString());
	}

}
