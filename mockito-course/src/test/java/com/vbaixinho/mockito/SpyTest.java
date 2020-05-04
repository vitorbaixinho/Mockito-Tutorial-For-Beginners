package com.vbaixinho.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.spy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SpyTest {

	@Test
	public void test() {
		List arrayListMock = mock(ArrayList.class);
//		mocks return a default value
		assertEquals(0, arrayListMock.size());
		
		arrayListMock.add("dummy");
		assertEquals(0, arrayListMock.size());
		
		stub(arrayListMock.size()).toReturn(10);
		assertEquals(10, arrayListMock.size());
		
		
		
		List arrayListSpy = spy(ArrayList.class);
//		mocks return a default value
		assertEquals(0, arrayListSpy.size());
		
		arrayListSpy.add("dummy");
		assertEquals(1, arrayListSpy.size());
		verify(arrayListSpy).add("dummy");
		verify(arrayListSpy, never()).clear();
		
		stub(arrayListSpy.size()).toReturn(10);
		assertEquals(10, arrayListSpy.size());
		
	}

}
