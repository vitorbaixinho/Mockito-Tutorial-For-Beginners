package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ArraysCompareTest {

	@Test
	public void testArraySort_RandomArray() {
		int[] numbers = {13,3,4,1};
		int[] expected = {1,3,4,13};
		Arrays.sort(numbers);
		assertArrayEquals(expected, numbers);
	}
	
	@Test(expected = RuntimeException.class)
	public void testArraySort_NullArray() throws Exception {
		int[] numbers = {};
		Arrays.sort(numbers);
	}
	
	@Test(timeout = 1000)
	public void testArraySort_SortPerformance() {
		int[] numbers = {13,3,4};
		for (int i = 0; i < 10000000; i++) {
			numbers[0] = i;
			Arrays.sort(numbers);
		}
	}

}
