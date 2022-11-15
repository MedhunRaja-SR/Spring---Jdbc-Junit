package cts.Mockito_courses;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import cts.Mockito_courses.Todo.TodoBusinessImpl;
import cts.Mockito_courses.Todo.TodoService;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockAnnotationTest {
	
	@Mock
	TodoService todoService ;
	
	@InjectMocks
	TodoBusinessImpl todoBusinessImpl ;
	
	@Captor
	ArgumentCaptor<String> argumentCaptor;
	
	@Test
	public void usingAMock() {

		List<String> todo = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

		when(todoService.retrieveTodos("Ranga")).thenReturn(todo);

		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Ranga");
		assertEquals(2, todos.size());
	}

	@Test
	public void letsTestDeleteNow() {

		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

		when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);

		todoBusinessImpl.deleteTodosNotRelatedToSpring("Ranga");

		verify(todoService).deleteTodo("Learn to Dance");

		verify(todoService, Mockito.never()).deleteTodo("Learn Spring MVC");

		verify(todoService, Mockito.never()).deleteTodo("Learn Spring");

		verify(todoService, Mockito.times(1)).deleteTodo("Learn to Dance");
		// atLeastOnce, atLeast

	}

	@Test
	public void captureArgument() {
		
		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		Mockito.when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);

		todoBusinessImpl.deleteTodosNotRelatedToSpring("Ranga");
		Mockito.verify(todoService).deleteTodo(argumentCaptor.capture());

		assertEquals("Learn to Dance", argumentCaptor.getValue());
	}
}
