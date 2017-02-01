package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class FullToDoListSpec {

    @Test
    public void totalToDoCount() throws IOException {
        ToDoController toDoController = new ToDoController();
        ToDo[] allToDos = toDoController.listToDos(new HashMap<>());
        assertEquals("Incorrect total number of toDos",300, allToDos.length);
    }

    @Test
    public void firstTodoInFullList() throws IOException {
        ToDoController toDoController = new ToDoController();
        ToDo[] allTodos = toDoController.listToDos(new HashMap<>());
        ToDo firstTodo = allTodos[0];
        assertEquals("Incorrect owner", "Blanche", firstTodo.owner);
        assertEquals("Incorrect status", false, firstTodo.status);
        assertEquals("Incorrect category", "software design", firstTodo.category);
    }


}
