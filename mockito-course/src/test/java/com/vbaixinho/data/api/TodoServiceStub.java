package com.vbaixinho.data.api;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService {

	public List<String> retrieveTodos(String user) {
		
		return Arrays.asList("Learn Spring MVC","Learn to dance","Learn Spring");
	}

	public void deleteTodo(String todo) {
		// TODO Auto-generated method stub
		
	}

}
