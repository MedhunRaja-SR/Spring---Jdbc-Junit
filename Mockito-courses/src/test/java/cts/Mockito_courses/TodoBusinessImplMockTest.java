package cts.Mockito_courses;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import cts.Mockito_courses.Todo.TodoBusinessImpl;
import cts.Mockito_courses.Todo.TodoService;

public class TodoBusinessImplMockTest {

	@Test
	public void usingAMock() {

		TodoService todoServiceMock = mock(TodoService.class);

		List<String> todo = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

		when(todoServiceMock.retrieveTodos("Ranga")).thenReturn(todo);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Ranga");
		assertEquals(2, todos.size());
	}

	@Test
	public void letsTestDeleteNow() {

		TodoService todoService = mock(TodoService.class);

		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

		when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);

		todoBusinessImpl.deleteTodosNotRelatedToSpring("Ranga");

		verify(todoService).deleteTodo("Learn to Dance");

		verify(todoService, Mockito.never()).deleteTodo("Learn Spring MVC");

		verify(todoService, Mockito.never()).deleteTodo("Learn Spring");

		verify(todoService, Mockito.times(1)).deleteTodo("Learn to Dance");
		// atLeastOnce, atLeast

	}

	@Test
	public void captureArgument() {
		ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

		TodoService todoService = mock(TodoService.class);

		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		Mockito.when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Ranga");
		Mockito.verify(todoService).deleteTodo(argumentCaptor.capture());

		assertEquals("Learn to Dance", argumentCaptor.getValue());
	}
}
