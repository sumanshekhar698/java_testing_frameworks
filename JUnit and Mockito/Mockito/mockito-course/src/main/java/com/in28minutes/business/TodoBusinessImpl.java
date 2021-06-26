package com.in28minutes.business;

import java.util.ArrayList;
import java.util.List;

import com.in28minutes.data.api.TodoService;

//		TodoBusinessImpl SUT (System under test)
public class TodoBusinessImpl {

//		TodoService dependency
	private TodoService todoService;

	TodoBusinessImpl(TodoService todoService) {
//		A kind of connection service
		this.todoService = todoService;
	}

	public List<String> retrieveTodosRelatedToSpring(String user) {
		List<String> filteredTodos = new ArrayList<String>();

		// passing the user String to retrieve his ToDo List
		List<String> allTodos = todoService.retrieveTodos(user);
		for (String todo : allTodos) {
			if (todo.contains("Spring")) {
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}

	public void deleteTodosNotRelatedToSpring(String user) {

		// passing the user String to retrieve his ToDo List
		List<String> allTodos = todoService.retrieveTodos(user);
		for (String todo : allTodos) {
			if (!todo.contains("Spring")) {
				this.todoService.deleteToDo(todo);
			}
		}

	}
}