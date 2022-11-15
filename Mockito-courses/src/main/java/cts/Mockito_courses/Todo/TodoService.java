package cts.Mockito_courses.Todo;

import java.util.List;

public interface TodoService {
	
	public List<String> retrieveTodos(String user);
	
	void deleteTodo(String todo);
}
