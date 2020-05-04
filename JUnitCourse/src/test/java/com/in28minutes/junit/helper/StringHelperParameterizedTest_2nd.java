package com.in28minutes.junit.helper;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StringHelperParameterizedTest_2nd {

	StringHelper stringHelper = new StringHelper();;

	String input;

	public StringHelperParameterizedTest_2nd(String input) {
		this.input = input;
	}

	@Parameters
	public static String[] testConditions() {

		String[] conditions = { "ABCD", "ABAB", "A", "AB" };
		return conditions;

	}

	// ABCD = false; ABAB = true; AB = true; A = falses
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_BasicFalse() {
		assertFalse(stringHelper.areFirstAndLastTwoCharactersTheSame(input));
	}

	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_BasicTrue() {
		assertTrue(stringHelper.areFirstAndLastTwoCharactersTheSame(input));
	}

	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_1char() {
		assertFalse(stringHelper.areFirstAndLastTwoCharactersTheSame(input));
	}

	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_2chars() {
		assertTrue(stringHelper.areFirstAndLastTwoCharactersTheSame(input));
	}
}
