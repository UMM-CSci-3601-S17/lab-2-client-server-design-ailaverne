package umm3601.todo;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;

public class OrderToDoList {

    private ToDoController toDoController;
    private ToDo[] allToDos;

    @Before
    public void initialize() throws IOException{
        toDoController = new ToDoController();
        allToDos = toDoController.listToDos(new HashMap<>());
    }

    @Test
    public void orderToDosByOwner() {
        ToDo[] sorted = toDoController.orderToDosByOwner(allToDos);
        assertEquals("First element is wrong", "Barry", sorted[0].owner);
        assertEquals("Last element is wrong", "Workman", sorted[sorted.length - 1].owner);
    }

    @Test
    public void orderToDosByBody() {
        ToDo[] sorted = toDoController.orderToDosByBody(allToDos);
        assertEquals("First element is wrong",
                "Ad sint incididunt officia veniam incididunt. Voluptate exercitation eu aliqua laboris occaecat deserunt cupidatat velit nisi sunt mollit sint amet.",
                sorted[0].body);
        assertEquals("Last element is wrong",
              "Voluptate sit velit occaecat pariatur. Qui adipisicing ipsum incididunt laborum.",
                sorted[sorted.length - 1].body);
    }

    @Test
    public void orderToDosByCategory() {
        ToDo[] sorted = toDoController.orderToDosByCategory(allToDos);
        assertEquals("First element is wrong", "groceries", sorted[0].category);
        assertEquals("Last message is wrong", "video games", sorted[sorted.length - 1].category);
    }
}
