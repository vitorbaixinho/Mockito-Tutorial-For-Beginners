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

@RunWith(PowerMockRunner.class)
@PrepareForTest(UtilityClass.class)
public class testInvokingPrivateMethod {
	
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
	public void testMethodCallingAStaticMethod() {

		List<Integer> todos = Arrays.asList(1,2,3);
		when(dependency.retrieveAllStats()).thenReturn(todos);
		
		PowerMockito.mockStatic(UtilityClass.class);
		when(UtilityClass.staticMethod(6)).thenReturn(150);
		
		int result = systemUnderTest.methodCallingAStaticMethod();
		
		assertEquals(150, result);
		
		PowerMockito.verifyStatic();
		UtilityClass.staticMethod(5);
	}
	

}
