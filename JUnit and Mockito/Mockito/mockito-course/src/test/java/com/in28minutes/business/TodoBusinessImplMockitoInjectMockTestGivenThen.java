package com.in28minutes.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;//important
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

import com.in28minutes.data.api.TodoService;

//@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockitoInjectMockTestGivenThen {

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

//	mocking with annotation
	@Mock
	TodoService todoService;
	/*
	 * OMIT: TodoService todoService = mock(TodoService.class);
	 */

//	Automatically inject its dependencies if declared with @Mocks via ConstructorInjection
	@InjectMocks
	TodoBusinessImpl todoBusinessImpl;
	/*
	 * OMIT: TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
	 */

//	Creating Argument Captor
	@Captor
	ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
	/*
	 * OMIT: ArgumentCaptor<String> argumentCaptor =
	 * ArgumentCaptor.forClass(String.class);
	 */

	@Test
	public void testReterieveTodosRelatedToSpring_usingBDD() {
		/*
		 * Given -> When -> Then
		 * 
		 */
//		TodoService todoServiceMock = mock(TodoService.class);
//		GIVEN initial setup-> No need, because we are using @Mock & JUnitRunner

		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

		given(todoService.retrieveTodos("Ranga")).willReturn(allTodos);
//		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);

//		WHEN
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Ranga");

//		THEN
		assertThat(filteredTodos.size(), is(2));// AE
	}

	@Test
	public void testDeleteTodosNotRelatedToSpring_usingBDD() {

		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		given(todoService.retrieveTodos("Ranga")).willReturn(allTodos);

//		WHEN
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Ranga");

//		THEN
		verify(todoService).deleteToDo("Learn to Dance");// if called
		then(todoService).should().deleteToDo("Learn to Dance");// similar like above

		verify(todoService, never()).deleteToDo("Learn to Drink");// if not called
		then(todoService).should(never()).deleteToDo("Learn to Drink");// similar like above

		verify(todoService, times(1)).deleteToDo("Learn to Dance");// called 1 times
		verify(todoService, atLeast(1)).deleteToDo("Learn to Dance");// called at least 5 times

	}

	@Test
	public void testDeleteTodosNotRelatedToSpring_usingBDD_argumentCapture() {

		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		given(todoService.retrieveTodos("Ranga")).willReturn(allTodos);

//		WHEN
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Ranga");

//		THEN
		then(todoService).should().deleteToDo("Learn to Dance");// similar like above

//		capturing it on the specific method call
		then(todoService).should().deleteToDo(argumentCaptor.capture());// similar like above

//		checking
		assertThat(argumentCaptor.getValue(), is("Learn to Dance"));
	}

	@Test
	public void testDeleteTodosNotRelatedToSpring_usingBDD_MultipleArgumentCapture() {

		List<String> allTodos = Arrays.asList("Learn Django MVC", "Learn Spring", "Learn to Dance");
		given(todoService.retrieveTodos("Ranga")).willReturn(allTodos);

//		WHEN
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Ranga");

//		THEN
		then(todoService).should().deleteToDo("Learn to Dance");// similar like above

//		capturing it on the specific method call
		then(todoService).should(times(2)).deleteToDo(argumentCaptor.capture());// similar like above

//		checking and capturing  Multiple calls
		assertThat(argumentCaptor.getAllValues().size(), is(2));
	}

}