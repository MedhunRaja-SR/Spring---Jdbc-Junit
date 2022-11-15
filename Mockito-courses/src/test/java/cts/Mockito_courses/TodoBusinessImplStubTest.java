package cts.Mockito_courses;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import cts.Mockito_courses.Todo.TodoBusinessImpl;
import cts.Mockito_courses.Todo.TodoService;
import cts.Mockito_courses.Todo.TodoServiceStub;

public class TodoBusinessImplStubTest {

	@Test
	public void usingAStub() {
		
		TodoService todoService = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Ranga");
		assertEquals(2, todos.size());
	}

}
