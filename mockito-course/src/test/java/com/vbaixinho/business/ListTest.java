package com.vbaixinho.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

public class ListTest {

	@Test
	public void testListMockSize_return10() {
		List list = mock(List.class);
		Mockito.when(list.size()).thenReturn(10);
		assertEquals(10, list.size());
	}
	
	@Test
	public void testListMockSize_returnMultipleValues() {
		List list = mock(List.class);
		Mockito.when(list.size()).thenReturn(10).thenReturn(12);
		assertEquals(10, list.size());
		assertEquals(12, list.size());
	}

	@Test
	public void testListMockGet() {
		List list = mock(List.class);
		Mockito.when(list.get(0)).thenReturn("teste");
		assertEquals("teste", list.get(0));
	}

	@Test
	public void testListMockGet_usingBDD() {
		
//		Given
		List list = mock(List.class);
		given(list.get(Mockito.anyInt())).willReturn("teste");
		
//		When
		String result = (String) list.get(0);
		
//		Then
		assertThat(result, is("teste"));
	}

	@Test
	public void testListMockGet_testArgumentMatcher() {
		List list = mock(List.class);
		Mockito.when(list.get(Mockito.anyInt())).thenReturn("teste");
		assertEquals("teste", list.get(0));
		assertEquals("teste", list.get(1));
		assertEquals("teste", list.get(2));
		assertEquals("teste", list.get(3));
	}
	
	@Test(expected = RuntimeException.class)
	public void testListMockGet_throwException() {
		List list = mock(List.class);
		Mockito.when(list.get(Mockito.anyInt())).thenThrow(new RuntimeException("somethingWrong"));
		list.get(0);
	}
	
	@Test(expected = RuntimeException.class)
	public void testListMockGet_mixedArguments() {
		List list = mock(List.class);
		Mockito.when(list.subList(Mockito.anyInt(), 5)).thenThrow(new RuntimeException("somethingWrong"));
		list.subList(0, 5);
	}
}
