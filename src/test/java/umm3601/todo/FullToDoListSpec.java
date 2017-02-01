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
}
