package com.mowitnow.motioncontrol;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ActionsTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetValue() {
		assertEquals(3, Actions.values().length);
		assertEquals(Actions.D, Actions.valueOf("D"));
		assertEquals(Actions.G, Actions.valueOf("G"));
		assertEquals(Actions.A, Actions.valueOf("A"));
	}

}
