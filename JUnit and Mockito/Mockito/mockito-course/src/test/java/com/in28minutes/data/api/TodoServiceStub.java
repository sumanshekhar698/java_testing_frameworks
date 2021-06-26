package com.in28minutes.data.api;

import java.util.Arrays;
import java.util.List;

//STUB a sample implementation of the main service
public class TodoServiceStub implements TodoService {

	public List<String> retrieveTodos(String user) {

		// dummy to do list return
		return Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

	}

	public void deleteToDo(String todD) {
		// TODO Auto-generated method stub

	}
}
