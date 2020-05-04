package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StringHelperParameterizedTest {
	
	StringHelper stringHelper = new StringHelper();
	String input;
	String output;

	public StringHelperParameterizedTest(String input, String output) {
		this.input = input;
		this.output = output;
	}
	
	@Parameters
	public static Collection<String[]> testConditpions() {
		String[][] expected = { {"AACD","CD"} , {"ACD","CD"} };
		return Arrays.asList(expected);
	}
	@Test
	public void testTruncateAInFirst2Positions_AinFirst2positions() {
		assertEquals(output,stringHelper.truncateAInFirst2Positions(input));
	}
	
	@Test
	public void testTruncateAInFirst2Positions_AinFirstPosition() {
		assertEquals(output,stringHelper.truncateAInFirst2Positions(input));
	}
}
