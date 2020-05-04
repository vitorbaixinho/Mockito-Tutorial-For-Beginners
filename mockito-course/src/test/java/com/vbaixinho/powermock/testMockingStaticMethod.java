package com.vbaixinho.powermock;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

@RunWith(PowerMockRunner.class)
public class testMockingStaticMethod {
	
//	@Rule
//	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@Mock
	Dependency dependency;
	
	@InjectMocks
	SystemUnderTest systemUnderTest;
//	TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
	
	@Captor
	ArgumentCaptor<String> stringCaptor;
////	Declare Argument Captor
//	ArgumentCaptor<String> stringCaptor = ArgumentCaptor.forClass(String.class);
	
	@Test
	public void testPrivateMethodUnderTest() throws Exception {

		List<Integer> todos = Arrays.asList(1,2,3);
		
		when(dependency.retrieveAllStats()).thenReturn(todos);
		
		long result = Whitebox.invokeMethod(systemUnderTest, "privateMethodUnderTest");
		
		assertEquals(6, result);
	}
	

}
