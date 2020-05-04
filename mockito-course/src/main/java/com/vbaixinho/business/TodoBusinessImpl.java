package com.vbaixinho.business;

import java.util.ArrayList;
import java.util.List;

import com.vbaixinho.data.api.TodoService;

// TodoBusinessImpl SUV (system under test)
// TodoService dependency
public class TodoBusinessImpl {

	private TodoService todoService;

	public TodoBusinessImpl(TodoService todoService) {
		this.todoService = todoService;
	}

	public List<String> retrieveTodosRelatedToSpring(String user) {

		List<String> filteredTodos = new ArrayList<String>();

		List<String> todos = todoService.retrieveTodos(user);

		for (String todo : todos) {
			if (todo.contains("Spring")) {
				filteredTodos.add(todo);
			}
		}

		return filteredTodos;
	}

	public void deleteTodosNotRelatedToSpring(String user) {

		List<String> todos = todoService.retrieveTodos(user);

		for (String todo : todos) {
			if (!todo.contains("Spring")) {
				todoService.deleteTodo(todo);
			}
		}
	}
}
