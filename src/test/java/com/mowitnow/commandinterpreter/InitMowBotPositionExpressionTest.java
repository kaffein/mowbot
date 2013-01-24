package com.mowitnow.commandinterpreter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InitMowBotPositionExpressionTest {
	private InitMowBotPositionExpression initMowBotPositionExpression;
	private InterpreterContext context;

	@Before
	public void setUp() throws Exception {
		context = new InterpreterContext();
		initMowBotPositionExpression = new InitMowBotPositionExpression("1 2 N");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInterpret() {
		assertNotNull(initMowBotPositionExpression.interpret(context));
		assertEquals(1, context.getMowBot().getPosition().getX());
		assertEquals(2, context.getMowBot().getPosition().getY());
		assertEquals("N", context.getMowBot().getPosition().getOrientation().getValue());
	}

	@Test
	public void testInitMowBotPositionExpression() {
		assertNotNull(initMowBotPositionExpression);
	}

	@Test
	public void testGetInput() {
		assertNotNull(initMowBotPositionExpression.getInput());
		assertEquals(3, initMowBotPositionExpression.getInput().split(" ").length);
	}

	@Test
	public void testSetInput() {
		assertNotNull(initMowBotPositionExpression);
	}

}
