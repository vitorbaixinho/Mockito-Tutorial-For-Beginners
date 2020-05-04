package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringHelperTest {
	
	StringHelper stringHelper;

	@Before
	public void setup() {
		stringHelper = new StringHelper();
	}

	@Test
	public void testTruncateAInFirst2Positions_AinFirst2positions() {
		assertEquals("CD",stringHelper.truncateAInFirst2Positions("AACD"));
	}
	
	@Test
	public void testTruncateAInFirst2Positions_AinFirstPosition() {
		assertEquals("CD",stringHelper.truncateAInFirst2Positions("ACD"));
	}

	@Test
	public void testTruncateAInFirst2Positions_WithoutAs() {
		assertEquals("CDEF",stringHelper.truncateAInFirst2Positions("CDEF"));
	}
	
	@Test
	public void testTruncateAInFirst2Positions_AinLast2Positions() {
		assertEquals("CDAA",stringHelper.truncateAInFirst2Positions("CDAA"));
	}
	
	@Test
	public void testTruncateAInFirst2Positions_StringWith2As() {
		assertEquals("",stringHelper.truncateAInFirst2Positions("AA"));
	}
	
	@Test
	public void testTruncateAInFirst2Positions_StringWith1As() {
		assertEquals("",stringHelper.truncateAInFirst2Positions("A"));
	}
	
	@Test
	public void testTruncateAInFirst2Positions_StringWith2Chars() {
		assertEquals("BC",stringHelper.truncateAInFirst2Positions("BC"));
	}
	

	// ABCD = false; ABAB = true; AB = true; A = falses
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_BasicFalse() {
		assertFalse(stringHelper.areFirstAndLastTwoCharactersTheSame("ABCD"));
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_BasicTrue() {
		assertTrue(stringHelper.areFirstAndLastTwoCharactersTheSame("ABAB"));
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_1char() {
		assertFalse(stringHelper.areFirstAndLastTwoCharactersTheSame("A"));
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_2chars() {
		assertTrue(stringHelper.areFirstAndLastTwoCharactersTheSame("AB"));
	}
}
