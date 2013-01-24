package com.mowitnow.commandinterpreter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InitLawnAreaBoundariesExpressionTest {
	private InitLawnAreaBoundariesExpression initLawnAreaBoundariesExpression;
	private InterpreterContext context;

	@Before
	public void setUp() throws Exception {
		context = new InterpreterContext();
		initLawnAreaBoundariesExpression = new InitLawnAreaBoundariesExpression("5 5");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInterpret() {
		assertNotNull(initLawnAreaBoundariesExpression.interpret(context));
		assertEquals(5, context.getLawnArea().getUpperRightMostX());
		assertEquals(5, context.getLawnArea().getUpperRightMostY());
	}

	@Test
	public void testInitLawnAreaBoundariesExpression() {
		assertNotNull(initLawnAreaBoundariesExpression);
	}

	@Test
	public void testGetInput() {
		assertNotNull(initLawnAreaBoundariesExpression.getInput());
		assertEquals(2, initLawnAreaBoundariesExpression.getInput().split(" ").length);
	}

	@Test
	public void testSetInput() {
		assertNotNull(initLawnAreaBoundariesExpression.getInput());
	}

}
