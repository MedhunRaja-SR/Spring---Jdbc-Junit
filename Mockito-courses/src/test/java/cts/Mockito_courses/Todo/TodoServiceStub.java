package cts.Mockito_courses.Todo;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService {
	
	public List<String> retrieveTodos(String user) {
		return Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
	}

	@Override
	public void deleteTodo(String todo) {
		// TODO Auto-generated method stub
		
	}
}
