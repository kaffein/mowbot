package com.mowitnow.motioncontrol;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CardinalPointTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetValue() {
	}

	@Test
	public void testGetValue() {
		assertEquals("N", CardinalPoint.N.getValue());
		assertEquals("E", CardinalPoint.E.getValue());
		assertEquals("W", CardinalPoint.W.getValue());
		assertEquals("S", CardinalPoint.S.getValue());
		assertEquals(4, CardinalPoint.values().length);
	}

}
