package com.in28minutes.data.api;

import java.util.List;

/* External Service - Lets say this comes from WunderList
 * But for now we don't have an implementation for it
*/
public interface TodoService {
	public List<String> retrieveTodos(String user);

	public void deleteToDo(String todo);
}