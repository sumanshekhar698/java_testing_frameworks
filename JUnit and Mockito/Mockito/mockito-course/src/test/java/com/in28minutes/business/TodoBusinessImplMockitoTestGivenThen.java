package com.in28minutes.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import com.in28minutes.data.api.TodoService;

public class TodoBusinessImplMockitoTestGivenThen {

	@Test
	public void testReterieveTodosRelatedToSpring_usingBDD() {
		/*
		 * Given -> When -> Then
		 */

//		GIVEN-> initial setup
		TodoService todoService = mock(TodoService.class);
		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		given(todoService.retrieveTodos("Ranga")).willReturn(allTodos);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);

//		WHEN -> Specific Action
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Ranga");

//		THEN -> validation
		assertThat(filteredTodos.size(), is(2));// AE
//		is() => HAMCREST MAtchers
	}

	@Test
	public void testDeleteTodosNotRelatedToSpring_usingBDD() {
//		GIVEN initial setup
		TodoService todoServiceMock = mock(TodoService.class);
		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

		given(todoServiceMock.retrieveTodos("Ranga")).willReturn(allTodos);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

//		WHEN
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Ranga");

//		THEN
		verify(todoServiceMock).deleteToDo("Learn to Dance");// if called with "Learn To Dance"
		then(todoServiceMock).should().deleteToDo("Learn to Dance");// similar like above

		verify(todoServiceMock, never()).deleteToDo("Learn Spring MVC");// if not called with "Learn To Dance"
		then(todoServiceMock).should(never()).deleteToDo("Learn Spring Season");// similar like above

		verify(todoServiceMock, times(1)).deleteToDo("Learn to Dance");// called 1 times
		verify(todoServiceMock, atLeast(1)).deleteToDo("Learn to Dance");// called at least 1 times

	}

	@Test
	public void testDeleteTodosNotRelatedToSpring_usingBDD_argumentCapture() {

//		declare argument captor
		ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

//		GIVEN initial setup
		TodoService todoServiceMock = mock(TodoService.class);

		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

		given(todoServiceMock.retrieveTodos("Ranga")).willReturn(allTodos);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

//		WHEN
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Ranga");

//		THEN
//		capturing it on the specific method call
		then(todoServiceMock).should().deleteToDo(argumentCaptor.capture());// similar like above

//		validation
		assertThat(argumentCaptor.getValue(), is("Learn to Dance"));
	}

	@Test
	public void testDeleteTodosNotRelatedToSpring_usingBDD_multipleArgumentCapture() {

//		declare argument captor [Here I want to capture Argument of type String]
		ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

//		GIVEN initial setup
		TodoService todoServiceMock = mock(TodoService.class);

		List<String> allTodos = Arrays.asList("Learn to rock and roll", "Learn Spring", "Learn to Dance");

		given(todoServiceMock.retrieveTodos("Ranga")).willReturn(allTodos);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

//		WHEN
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Ranga");

//		THEN
//		capturing it on the specific method call
		then(todoServiceMock).should(times(2)).deleteToDo(argumentCaptor.capture());// similar like above

//		checking and capturing  Multiple calls
		assertThat(argumentCaptor.getAllValues().size(), is(2));
	}

}