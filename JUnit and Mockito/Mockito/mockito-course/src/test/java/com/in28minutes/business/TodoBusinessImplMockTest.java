package com.in28minutes.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.in28minutes.data.api.TodoService;

public class TodoBusinessImplMockTest {

	@Test
	public void testretrieveTodosRelatedToSpring_usingAMock1() {

//		Mocking an interface for its implementation class
		TodoService todoServiceMock = mock(TodoService.class);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		/*
		 * An example of nice mock , because its returning a empty list of String when
		 * no instruction is specified
		 */
		List<String> filteredToDos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(0, filteredToDos.size());
	}

	@Test
	public void testretrieveTodosRelatedToSpring_usingAMock2() {

		TodoService todoServiceMock = mock(TodoService.class);

		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
//		specifying some instruction
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

		List<String> filteredToDos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

		assertEquals(2, filteredToDos.size());
//		if we want to test several classes  StubClass will start becoming more complex

	}

}