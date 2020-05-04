package com.vbaixinho.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import com.vbaixinho.data.api.TodoService;

public class TodoBusinessImplMockTest {

	@Test
	public void testRetrieveTodosRelatedToSpring_usingAMock() {

		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos = Arrays.asList("Learn Spring MVC","Learn to dance","Learn Spring");
		when(todoServiceMock.retrieveTodos("mock_dummy")).thenReturn(todos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("mock_dummy");
		
		assertEquals(2, filteredTodos.size());
	}
	
	@Test
	public void testRetrieveTodosRelatedToSpring_usingEmptyList() {

		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos = Arrays.asList();
		when(todoServiceMock.retrieveTodos("mock_dummy")).thenReturn(todos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("mock_dummy");
		
		assertEquals(0, filteredTodos.size());
	}
	
	@Test
	public void testRetrieveTodosRelatedToSpring_usingBDD() {

//		Given - setup
		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos = Arrays.asList("Learn Spring MVC","Learn to dance","Learn Spring");
		given(todoServiceMock.retrieveTodos("mock_dummy")).willReturn(todos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
//		When - method call
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("mock_dummy");
		
//		Then - check
		assertThat(filteredTodos.size(), is(2));
	}
	
	@Test
	public void testDeleteTodosNotRelatedToSpring_usingBDD() {

//		Given - setup
		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos = Arrays.asList("Learn Spring MVC","Learn to dance","Learn Spring");
		given(todoServiceMock.retrieveTodos("mock_dummy")).willReturn(todos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
//		When - method call
		todoBusinessImpl.deleteTodosNotRelatedToSpring("mock_dummy");
		
//		Then - check
		verify(todoServiceMock).deleteTodo("Learn to dance"); //verify if a specific method is called
		then(todoServiceMock).should().deleteTodo("Learn to dance");
		
		verify(todoServiceMock, times(1)).deleteTodo("Learn to dance"); //verify if a specific method is called only ONCE
		then(todoServiceMock).should(times(1)).deleteTodo("Learn to dance");
		
		verify(todoServiceMock, atLeastOnce()).deleteTodo("Learn to dance"); //verify if a specific method is called only ONCE
		then(todoServiceMock).should(atLeastOnce()).deleteTodo("Learn to dance");
		
		verify(todoServiceMock, never()).deleteTodo("Learn Spring MVC"); //verify if a specific method is not called
		then(todoServiceMock).should(never()).deleteTodo("Learn Spring MVC");
		
		verify(todoServiceMock, never()).deleteTodo("Learn Spring"); //verify if a specific method is not called
	}
	
	@Test
	public void testDeleteTodosNotRelatedToSpring_usingBDD_argumentCaptor() {

//		Declare Argument Captor
		ArgumentCaptor<String> stringCaptor = ArgumentCaptor.forClass(String.class);
		
//		Given - setup
		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos = Arrays.asList("Learn Spring MVC","Learn to dance","Learn Spring");
		given(todoServiceMock.retrieveTodos("mock_dummy")).willReturn(todos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
//		When - method call
		todoBusinessImpl.deleteTodosNotRelatedToSpring("mock_dummy");
		
//		Then - check
		then(todoServiceMock).should().deleteTodo(stringCaptor.capture());
		assertThat(stringCaptor.getValue(), is("Learn to dance"));
	}

}
