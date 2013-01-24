package com.mowitnow.commandinterpreter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MotionExpressionTest {
	private MotionExpression motionExpression;
	private InterpreterContext context;

	@Before
	public void setUp() throws Exception {
		motionExpression = new MotionExpression("GAGAGAGAA");
		context = new InterpreterContext();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInterpret() {
		assertEquals(9, motionExpression.interpret(context).size());
	}

	@Test
	public void testMotionExpression() {
		assertNotNull(motionExpression);
	}

	@Test
	public void testGetInput() {
		assertNotNull(motionExpression.getInput());
		assertEquals("GAGAGAGAA", motionExpression.getInput());
	}

	@Test
	public void testSetInput() {
		motionExpression.setInput("GAAGGAAGAGAGA");
		assertFalse(motionExpression.getInput().length() == 4);
		assertNotNull(motionExpression.getInput());
		assertNotSame("GAGAGAGAA", motionExpression.getInput());
	}

}
