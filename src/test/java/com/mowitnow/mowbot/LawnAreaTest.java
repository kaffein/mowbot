package com.mowitnow.mowbot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LawnAreaTest {
	private LawnArea lawnArea;
	private List<MowBot> mowers;

	@Before
	public void setUp() throws Exception {
		lawnArea = new LawnArea();
		lawnArea.setUpperRightMostX(10);
		lawnArea.setUpperRightMostY(20);
		
		mowers = new ArrayList<MowBot>();
		lawnArea.getMowers().add(new MowBot());
		lawnArea.getMowers().add(new MowBot());
		lawnArea.getMowers().add(new MowBot());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLawnArea() {
		assertNotNull(lawnArea);
	}

	@Test
	public void testGetUpperRightMostX() {
		assertEquals(10, lawnArea.getUpperRightMostX());
	}

	@Test
	public void testSetUpperRightMostX() {
		lawnArea.setUpperRightMostX(20);
		assertEquals(20, lawnArea.getUpperRightMostX());
	}

	@Test
	public void testGetUpperRightMostY() {
		lawnArea.setUpperRightMostY(8);
		assertEquals(8, lawnArea.getUpperRightMostY());
	}

	@Test
	public void testSetUpperRightMostY() {
		lawnArea.setUpperRightMostY(12);
		assertEquals(12, lawnArea.getUpperRightMostY());
	}

	@Test
	public void testGetMowers() {
		assertNotNull(lawnArea.getMowers());
		assertEquals(3, lawnArea.getMowers().size());
	}

	@Test
	public void testSetMowers() {
		mowers = new ArrayList<MowBot>();
		mowers.add(new MowBot());
		lawnArea.setMowers(mowers);
		
		assertNotNull(lawnArea.getMowers());
		assertEquals(1, lawnArea.getMowers().size());
	}

}